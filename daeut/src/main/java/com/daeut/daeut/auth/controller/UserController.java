package com.daeut.daeut.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daeut.daeut.auth.dto.CustomUser;
import com.daeut.daeut.auth.dto.Reservation;
import com.daeut.daeut.auth.dto.Users;
import com.daeut.daeut.auth.service.UserService;
import com.daeut.daeut.reservation.dto.Cart;
import com.daeut.daeut.reservation.service.CartService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import javax.servlet.http.HttpSession;

import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @GetMapping("/userMypage")
    public String userMypage(@AuthenticationPrincipal CustomUser customUser, Model model) throws Exception {
        log.info("/user/userMypage");

        Users user = customUser.getUser();
        model.addAttribute("user", user);

        return "/user/userMypage";
    }

    @GetMapping("/userMypageUpdate")
    public String userMypageUpdate(@AuthenticationPrincipal CustomUser customUser, Model model) throws Exception {
        log.info("/user/userMypageUpdate");

        Users user = customUser.getUser();
        model.addAttribute("user", user);

        return "/user/userMypageUpdate";
    }

    @PostMapping("/userMypageUpdateDone")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String userMypageUpdateDone(@RequestParam("action") String action, @ModelAttribute Users user) throws Exception {
        if ("delete".equals(action)) {
            int result = userService.delete(user);
            log.info("Delete result: " + result);
            if (result > 0) {
                return "redirect:/index";  // 탈퇴 처리 후 리다이렉트할 페이지
            } else {
                return "redirect:/user/userMypage";
            }
        } else if ("update".equals(action)) {
            int result = userService.update(user);
            log.info("Update result: " + result);
            if (result > 0) {
                return "redirect:/user/userMypage";
            } else {
                return "redirect:/user/userMypageUpdate";
            }
        }
        return "redirect:/user/userMypage"; // 기본적으로 리다이렉트할 페이지
    }
    

    @GetMapping("/userReservation")
    public String userReservation(Model model, Principal principal) throws Exception {
        log.info("/user/userReservation");
        String userId = principal.getName();
        List<Reservation> reservations = userService.getUserReservations(userId);
        model.addAttribute("reservations", reservations);
        return "/user/userReservation";
    }

    @GetMapping("/userLikeTip")
    public String userLikeTip() {
        log.info("/user/userLikeTip");
        return "/user/userLikeTip";
    }

    @GetMapping("/userReview")
    public String userReview() {
        log.info("/user/userReview");
        return "/user/userReview";
    }

    @GetMapping("/userCoupon")
    public String userCoupon() {
        log.info("/user/userCoupon");
        return "/user/userCoupon";
    }

    @GetMapping("/userPartner")
    public String userPartner() {
        log.info("/user/userPartner");
        return "/user/userPartner";
    }

    @GetMapping("/userPartnerDone")
    public String userPartnerDone() {
        log.info("/user/userPartnerDone");
        return "/user/userPartnerDone";
    }

    // 장바구니
    @GetMapping("/userCart")
        public String userCart(Model model, HttpSession session) {
        Users user = (Users) session.getAttribute("user");
        int userNo = user.getUserNo();
        
        // 사용자의 장바구니 목록을 서비스를 통해 가져옴
        List<Cart> cartList;
        try {
            cartList = cartService.cartList(userNo);
            model.addAttribute("cartList", cartList);
            model.addAttribute("user", user);
        } catch (Exception e) {
            log.info("장바구니 조회 중 에러 발생...");
            e.printStackTrace();
        }
    
        return "/user/userCart";
    }

    // 파트너 신청 엔드포인트
    @PostMapping("/request-partner")
    public String requestPartner(@RequestParam String userId) {
        try {
            userService.requestPartner(userId);
        } catch (Exception e) {
            log.error("Error requesting partner status", e);
        }
        return "redirect:/user/userPartnerDone";
    }

    // 관리자가 파트너 신청을 승인하는 엔드포인트
    @PostMapping("/approve-partner")
    public String approvePartner(@RequestParam String userId) {
        try {
            userService.approvePartner(userId);
        } catch (Exception e) {
            log.error("Error approving partner status", e);
        }
        return "redirect:/user/partnerApprovalDone";
    }
}

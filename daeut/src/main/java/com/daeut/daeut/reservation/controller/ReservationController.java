package com.daeut.daeut.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daeut.daeut.reservation.dto.Files;
import com.daeut.daeut.reservation.dto.Option;
import com.daeut.daeut.reservation.dto.Page;
import com.daeut.daeut.reservation.dto.Services;
import com.daeut.daeut.reservation.service.FileService;
import com.daeut.daeut.reservation.service.ReservationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private FileService fileService;

    /**
     * 전체 조회
     * @write jslee
     * @param model
     * @param page
     * @param option
     * @return
     * @throws Exception
     */
	@GetMapping("/reservation")
	public String reservationList(Model model, Page page, Option option) throws Exception{
        String keyword = option.getKeyword();

        if(keyword == null || option.getKeyword() == ""){
            keyword = "";
            option.setKeyword(keyword);
            
            model.addAttribute("option", option);
        }else
            model.addAttribute("option", option);

        List<Services> serviceList = reservationService.serviceList(page, option);
        
        model.addAttribute("serviceList", serviceList);
        model.addAttribute("page", page);
        
        return "reservation/reservation";
	}

    // 채팅 로직 작성 필요
	@GetMapping("/chat")
	public String chat() {
		return "reservation/chat";
	} 

    /**
     * 단일 조회
     * @write jslee
     * @param serviceNo
     * @param file
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping("/reservationRead")
	public String reservationRead(@RequestParam("serviceNo") int serviceNo, Model model, Files file) throws Exception {
        Services service = reservationService.serviceSelect(serviceNo);
        Files thumbnail = reservationService.SelectThumbnail(serviceNo);
        List<Files> files = reservationService.SelectFiles(serviceNo);

        file.setParentTable("service");
        file.setParentNo(serviceNo);
        List<Files> fileList = fileService.listByParent(file);

        log.info("service? {}",service);
        log.info("fileList? {}",fileList);

        model.addAttribute("service", service);
        model.addAttribute("fileList", fileList);
        model.addAttribute("thumbnail", thumbnail);
        model.addAttribute("files", files);

        return "reservation/reservationRead";
    }

	/**
     * 글 등록 
     * @write jslee
     * @return
     */
	@GetMapping("/reservationInsert")
	public String moveToReservationInsert() {
		return "reservation/reservationInsert";
	}

    /**
     * 등록 처리
     * @write jslee
     * @param service
     * @return
     * @throws Exception
     */
    @PostMapping("/reservationInsert")
    public String reservationInsert(Services service) throws Exception {
        log.info("서비스 정보: {}", service);
        int result = reservationService.serviceInsert(service);

        if (result == 0) {
            log.info("게시글 등록 실패...");
            return "redirect:/reservation/reservationInsert";
        }

        log.info("게시글 등록 성공...");
        return "redirect:/reservation/reservation";
    }

    /**
     * 글 수정
     * @write jslee
     * @param serviceNo
     * @param model
     * @param file
     * @return
     * @throws Exception
     */
    @GetMapping("/reservationUpdate")
    public String reservationUpdate(@RequestParam("serviceNo") int serviceNo, Model model, Files file) throws Exception {
        Services service = reservationService.serviceSelect(serviceNo);
        Files thumbnail = reservationService.SelectThumbnail(serviceNo);
        List<Files> files = reservationService.SelectFiles(serviceNo);

        file.setParentTable("service");
        file.setParentNo(serviceNo);
        List<Files> fileList = fileService.listByParent(file);

        model.addAttribute("service", service);
        model.addAttribute("fileList", fileList);
        model.addAttribute("thumbnail", thumbnail);
        model.addAttribute("files", files);

        return "reservation/reservationUpdate";
    }

    /**
     * 수정처리
     * @param service
     * @return
     * @throws Exception
     */
    @PostMapping("/reservationUpdate")
    public String updatePro(Services service) throws Exception {

        Files file = new Files();
        file.setParentTable("service");
        file.setParentNo(service.getServiceNo());
        fileService.deleteByParent(file);

        int result = reservationService.serviceUpdate(service);
        log.info("service? {}",service);

        int serviceNo = service.getServiceNo();

        if (result == 0) {
            log.info("게시글 수정 실패...");
            return "redirect:/reservation/reservationUpdate?serviceNo=" + serviceNo + "&error";
        }

        log.info("게시글 수정 성공...");
        return "redirect:/reservation/reservation";
    }

    /**
     * 글 삭제
     * @write jslee
     * @param serviceNo
     * @return
     * @throws Exception
     */
    @PostMapping("/reservationDelete")
    public String reservationDelete(@RequestParam("serviceNo") int serviceNo) throws Exception {
        int result = reservationService.serviceDelete(serviceNo);

        if (result == 0) {
            log.info("게시글 삭제 실패...");
            return "redirect:/reservation/reservationUpdate?serviceNo=" + serviceNo + "&error";
        }

        Files file = new Files();
        file.setParentTable("service");
        file.setParentNo(serviceNo);
        fileService.deleteByParent(file);

        log.info("게시글 삭제 성공...");
        return "redirect:/reservation/reservation";
    }
}
package com.daeut.daeut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/reservation")
public class PageController {
	
	@GetMapping("/{path}")
	public String getMethodName(@PathVariable("path") String path ) {
		return path;
	}

	@GetMapping("/reservation")
	public String reservationlist() {
		return "/reservation/reservation";
	}

	@GetMapping("/chat")
	public String chat() {
		return "/reservation/chat";
	} 

	@GetMapping("/reservationRead")
	public String reservationread() {
		return "/reservation/reservationRead";
	}

	
	@GetMapping("/reservationInsert")
	public String reservationinsert() {
		return "/reservation/reservationInsert";
	}

	// @GetMapping("/reservationUpdate")
	// public String reservationupdate() {
	// 	return "/reservation/reservationUpdate";
	// }


	// 결제 이동
	@GetMapping("/payment")
    public String payment() {
        return "/reservation/payment";
    }

	// 결제 성공
	@GetMapping("/paymentDone")
    public String paymentDone() {
        return "/reservation/paymentDone";
    }

	// 결제 실패
    @GetMapping("/paymentFalse")
    public String paymentFalse() {
        return "/reservation/paymentFalse";
    }
	
}
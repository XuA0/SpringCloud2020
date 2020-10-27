package com.xuao.springcloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.xuao.springcloud.service.PaymentHystrixService;

@RestController
public class OrderHystrixController {

	private static final Logger log = LoggerFactory.getLogger(OrderHystrixController.class);

	@Autowired
	private PaymentHystrixService paymentHystrixService;

	@GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
	public String paymentInfo_OK(@PathVariable("id") Integer id) {
		String result = paymentHystrixService.paymentInfo_OK(id);
		return result;
	}

	@GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
	public String paymentInfo_Timeout(@PathVariable("id") Integer id) {
		String result = paymentHystrixService.paymentInfo_Timeout(id);
		return result;
	}
}

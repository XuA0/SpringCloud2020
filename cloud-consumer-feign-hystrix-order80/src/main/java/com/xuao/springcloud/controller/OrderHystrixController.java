package com.xuao.springcloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xuao.springcloud.service.PaymentHystrixService;

@RestController
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
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
//	@HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
//			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500") })
//	@HystrixCommand
	public String paymentInfo_Timeout(@PathVariable("id") Integer id) {
		String result = paymentHystrixService.paymentInfo_Timeout(id);
		return result;
	}
	
	public String paymentInfo_TimeoutHandler(Integer id) {
		return "i am consumer 80 ,system error";
	}
	public String payment_Global_FallbackMethod() {
		return "i am consumer 80,global fallback ,system error";
	}
}

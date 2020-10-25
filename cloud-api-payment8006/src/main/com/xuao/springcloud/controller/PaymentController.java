package com.xuao.springcloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.hutool.core.lang.UUID;

@RestController
public class PaymentController {
	Logger logger = LoggerFactory.getLogger(PaymentController.class);
	
	@Value("${server.port}")
	private String serverPort;

	@RequestMapping("/payment/consul")
	public String paymentConsul() {
		return "springcloud with consul : " + serverPort + "\t" + UUID.randomUUID().toString();
	}
}

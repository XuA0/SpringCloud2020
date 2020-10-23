package com.xuao.springcloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderZKController {
	Logger logger = LoggerFactory.getLogger(OrderZKController.class);
	
	public static final String INVOKE_URL = "http://cloud-provider-payment";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/consumer/payment/zk")
	public String paymentInfo() {
		String result = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
		return result;
	}
	
}

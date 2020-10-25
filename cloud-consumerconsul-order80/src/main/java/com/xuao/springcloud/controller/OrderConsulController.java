package com.xuao.springcloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderConsulController {
	Logger logger = LoggerFactory.getLogger(OrderConsulController.class);

	public static final String INVOKE_URL = "http://consul-provider-payment";

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/consumer/payment/consul")
	public String paymentInfo() {
		String result = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
		return result;
	}

}

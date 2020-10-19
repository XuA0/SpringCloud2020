package com.xuao.springcloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.xuao.springcloud.entities.CommonResult;
import com.xuao.springcloud.entities.Payment;

@RestController
public class OrderController {
	Logger log = LoggerFactory.getLogger(OrderController.class);
	public static final String PAYMENT_URL = "http://localhost:8001";

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/consumer/payment/create")
	public CommonResult<Payment> create(@RequestBody Payment payment) {
		return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
	}

	@GetMapping("/consumer/payment/get/{id}")
	public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
		return (CommonResult)restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
	}
}

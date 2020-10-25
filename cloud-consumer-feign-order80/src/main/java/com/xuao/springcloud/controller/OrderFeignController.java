package com.xuao.springcloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.xuao.springcloud.entities.CommonResult;
import com.xuao.springcloud.entities.Payment;
import com.xuao.springcloud.service.PaymentFeignService;

@RestController
public class OrderFeignController {
	private static final Logger log = LoggerFactory.getLogger(OrderFeignController.class);

	@Autowired
	private PaymentFeignService paymentFeignService;

	@GetMapping("/consumer/payment/get/{id}")
	public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
		return paymentFeignService.getPaymentById(id);
	}
}

package com.xuao.springcloud.controller;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xuao.springcloud.dao.PaymentDao;
import com.xuao.springcloud.entities.CommonResult;
import com.xuao.springcloud.entities.Payment;
import com.xuao.springcloud.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PaymentController {

	Logger log = LoggerFactory.getLogger(PaymentController.class);
	
	@Value(value= "${server.port}")
	private String port;
	
	@Resource
	private PaymentService paymentService;

	@PostMapping(value = "/payment/create")
	public CommonResult create(@RequestBody Payment payment) {
		int result = paymentService.create(payment);
		log.info("******create result: " + result);

		if (result > 0) {
			return new CommonResult(200, "insert to database success . port" + port, result);
		} else {
			return new CommonResult(444, "insert to database failed", null);
		}
	}

	@GetMapping(value = "/payment/get/{id}")
	public CommonResult getPaymentById(@PathVariable("id") Long id) {
		Payment payment = paymentService.getPaymentById(id);
		log.info("******create result: " + payment);

		if (payment != null) {
			return new CommonResult(200, "search success . port" + port, payment);
		} else {
			return new CommonResult(444, "search failed, id :" + id, null);
		}
	}
	
	@GetMapping(value = "/payment/lb")
	public String getPaymentLB() {
		return port;
	}
	
	@GetMapping(value = "/payment/feign/timeout ")
	public String paymentFeignTimeout() {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return port;
	}
}

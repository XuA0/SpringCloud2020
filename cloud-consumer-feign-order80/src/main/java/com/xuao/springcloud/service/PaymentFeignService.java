package com.xuao.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.xuao.springcloud.entities.CommonResult;
import com.xuao.springcloud.entities.Payment;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
	
	@GetMapping("/payment/get/{id}")
	CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}

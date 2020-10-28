package com.xuao.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService{

	@Override
	public String paymentInfo_OK(Integer id) {
		// TODO Auto-generated method stub
		return "-------PaymentFallbacService fall back-paymentInfo_OK-------";
	}

	@Override
	public String paymentInfo_Timeout(Integer id) {
		// TODO Auto-generated method stub
		return "-------PaymentFallbacService fall back-paymentInfo_Timeout-------";
	}

}

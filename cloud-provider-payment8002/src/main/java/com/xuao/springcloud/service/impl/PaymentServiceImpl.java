package com.xuao.springcloud.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xuao.springcloud.dao.PaymentDao;
import com.xuao.springcloud.entities.Payment;
import com.xuao.springcloud.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Resource
	private PaymentDao paymentDao;

	public int create(Payment payment) {
		return paymentDao.create(payment);
	}

	public Payment getPaymentById(Long id) {
		return paymentDao.getPaymentById(id);
	}
}

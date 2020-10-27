package com.xuao.springcloud.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
	public String paymentInfo_OK(Integer id) {
		return "线程池： " + Thread.currentThread().getName() + "   paymentInfo_OK,id:" + id + " 正常访问！";
	}

	/**
	 * 超时访问，演示降级
	 * 
	 * @param id
	 * @return
	 */
	public String paymentInfo_Timeout(Integer id) {
		int timeNumber = 3;
		try {
			TimeUnit.SECONDS.sleep(timeNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "线程池： " + Thread.currentThread().getName() + "   paymentInfo_OK,id:" + id + " 耗时(秒):" + timeNumber;
	}

}

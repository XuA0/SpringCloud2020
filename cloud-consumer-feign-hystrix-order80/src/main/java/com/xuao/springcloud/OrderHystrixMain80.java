package com.xuao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrderHystrixMain80 {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(OrderHystrixMain80.class, args);
	}

}


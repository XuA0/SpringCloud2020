package com.xuao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PaymentHystirxMain8001 {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(PaymentHystirxMain8001.class, args);
	}

}

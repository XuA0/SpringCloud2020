package com.xuao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMain3344 {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ConfigCenterMain3344.class, args);
	}

}

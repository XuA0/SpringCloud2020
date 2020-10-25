package com.xuao.springcloud.controller;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.xuao.springcloud.entities.CommonResult;
import com.xuao.springcloud.entities.Payment;
import com.xuao.springcloud.lib.LoadBalancer;

@RestController
public class OrderController {
	Logger log = LoggerFactory.getLogger(OrderController.class);
	
	public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
	
	@Autowired
	private LoadBalancer loadBalancer;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient discoveryClient;

	@PostMapping("/consumer/payment/create")
	public CommonResult<Payment> create(@RequestBody Payment payment) {
		return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
	}

	@GetMapping("/consumer/payment/get/{id}")
	public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
		return (CommonResult)restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
	}
	
	@GetMapping("/consumer/payment/getForEntity/{id}")
	public CommonResult<Payment> getPayment2(@PathVariable("id") Long id) {
		ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
		if (entity.getStatusCode().is2xxSuccessful()) {
			return entity.getBody();
		}else {
			return new CommonResult(444,"failed");
		}
		
		
	}
	
	@GetMapping("/consumer/payment/lb")
	public String getPaymentLB() {
		List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
		if(instances == null || instances.size()<=0) {
			return null;
		}
		ServiceInstance serviceInstance = loadBalancer.instances(instances);
		URI uri = serviceInstance.getUri();
		
		return (String)restTemplate.getForObject(uri + "/payment/lb", String.class); 
	}
}

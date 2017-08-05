package com.huahouye.spring.cloud.eureka.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConcumerController {
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/consumer")
	@ResponseBody
	public String consumer() {
		// 通过 loadBalancerClient 的 choose 函数来负载均衡的选出一个 eureka-client 的
		// 服务实例，这个服务实例的基本信息存储在ServiceInstance中
		ServiceInstance serviceInstance = loadBalancerClient
				.choose("h-springcloud-001-eureka-client");
		String url = "http://" + serviceInstance.getHost() + ":"
				+ serviceInstance.getPort() + "/hello";
		System.out.println(url);
		return restTemplate.getForObject(url, String.class)
		;
	}

}

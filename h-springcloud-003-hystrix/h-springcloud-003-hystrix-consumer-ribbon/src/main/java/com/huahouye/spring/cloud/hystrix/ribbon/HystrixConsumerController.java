package com.huahouye.spring.cloud.hystrix.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class HystrixConsumerController {

	@Autowired
	private Service service;

	// http://desktop-957qmja:8764/consumer
	@RequestMapping("/consumer")
	@ResponseBody
	public String consumer() {
		return service.consumer();
	}

	// http://desktop-957qmja:8764/hystrix
	@RequestMapping("/hystrix")
	@ResponseBody
	public String hystrix() {
		return service.hystrix();
	}

}

@Component("service")
class Service {

	@Autowired
	RestTemplate restTemplate;

	// @HystrixCommand 注解来指定服务降级方法
	@HystrixCommand(fallbackMethod = "fallback")
	public String consumer() {
		return restTemplate.getForObject("http://h-springcloud-001-eureka-client/hello",
				String.class);
	}

	/**
	 * http://h-springcloud-001-eureka-client/hystrix 的实现里面
	 * @return
	 */
	@HystrixCommand(fallbackMethod = "fallback")
	public String hystrix() {
		return restTemplate.getForObject("http://h-springcloud-001-eureka-client/hystrix",
				String.class);
	}

	public String fallback() {
		return "fallback";
	}
}

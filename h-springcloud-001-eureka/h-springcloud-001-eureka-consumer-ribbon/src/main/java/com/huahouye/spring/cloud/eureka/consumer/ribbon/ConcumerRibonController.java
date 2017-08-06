package com.huahouye.spring.cloud.eureka.consumer.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConcumerRibonController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/consumer")
	@ResponseBody
	public String consumer() {
		// 这里请求的host位置并没有使用一个具体的IP地址和端口的形式，而是采用了服务名的方式组成。
		// Spring Cloud Ribbon 有一个拦截器，它能够在这里进行实际调用的时候，自动的去选取服
		// 务实例，并将实际要请求的 IP 地址和端口替换这里的服务名，从而完成服务接口的调用。
		return restTemplate.getForObject("http://h-springcloud-001-eureka-client/hello",
				String.class);
	}

}

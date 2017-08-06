package com.huahouye.spring.cloud.eureka.consumer.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerFeignController {

	@Autowired
	private IConsumerFeign iConsumerFeign;

	@RequestMapping("/consumer")
	@ResponseBody
	public String consumer() {
		return iConsumerFeign.hello();
	}

}

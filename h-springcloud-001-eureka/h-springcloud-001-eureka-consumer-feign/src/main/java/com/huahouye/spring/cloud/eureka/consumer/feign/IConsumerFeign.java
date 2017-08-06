package com.huahouye.spring.cloud.eureka.consumer.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author huahouye@gmail.com
 * 
 * 绑定 h-springcloud-001-eureka-client 服务的 /hello 接口
 *
 */
@FeignClient("h-springcloud-001-eureka-client") // 注解指明服务提供者
public interface IConsumerFeign {

	@RequestMapping("/hello") // 注解指明服务提供者的方法
	String hello();

}

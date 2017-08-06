package com.huahouye.spring.cloud.eureka.consumer.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 当 Ribbon 与 Eureka 联合使用时，ribbonServerList 会被 DiscoveryEnabledNIWSServerList 重写，
 * 扩展成从 Eureka 注册中心中获取服务实例列表。同时它也会用 NIWSDiscoveryPing 来取代 IPing，它将职责委托
 * 给 Eureka 来确定服务端是否已经启动。
 * 
 * @author huahouye@gmail.com
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaConsumerRibbonApplication {

	@Bean
	@LoadBalanced // 为 RestTemplate 增加 @LoadBalanced 注解
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumerRibbonApplication.class, args);
	}

}

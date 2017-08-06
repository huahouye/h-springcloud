package com.huahouye.spring.cloud.eureka.consumer.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Spring Cloud Feign 是一套基于 Netflix Feign 实现的声明式服务调用客户端。
 * 它使得编写 Web 服务客户端变得更加简单。我们只需要通过创建接口并用注解来配置它既可
 * 完成对 Web 服务接口的绑定。它具备可插拔的注解支持，包括 Feign 注解、JAX-RS 注解。
 * 它也支持可插拔的编码器和解码器。Spring Cloud Feign 还扩展了对 Spring MVC
 * 注解的支持，同时还整合了 Ribbon 和 Eureka 来提供均衡负载的 HTTP 
 * 
 * @author huahouye@gmail.com客户端实现。
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class EurekaConsumerFeignApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumerFeignApplication.class, args);
	}

}

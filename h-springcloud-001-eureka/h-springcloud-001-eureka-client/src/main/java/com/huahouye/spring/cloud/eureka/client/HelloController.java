package com.huahouye.spring.cloud.eureka.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;

@RestController
public class HelloController {

	@Autowired
	@Lazy
	private EurekaClient eurekaClient;

	// 来至 properties 或 yaml 配置文件
	@Value("${spring.application.name}")
	private String appName;

	// 启动 eureka server 和本 eureka client 程序后 浏览器打开 http://172.18.1.187:[端口]/hello
	// 可以看到 Hello form app H-SPRINGCLOUD-001-EUREKA-CLIENT 返回
	@RequestMapping("/hello")
	@ResponseBody
	public String sayHello() {
		return String.format("Hello form app %s", eurekaClient.getApplication(appName).getName());
	}
	
	/**
	 * 提供给服务 Hystrix 降级 使用
	 * 可以将服务提供者的逻辑加一些延迟
	 * 通过HystrixCommand注解中指定的降级逻辑进行执行，因此该请求的结果返回了
	 * fallback。这样的机制，对自身服务起到了基础的保护，同时还为异常情况提供了
	 * 自动的服务降级切换机制
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	@RequestMapping("/hystrix")
	@ResponseBody
	public String hystrix() throws InterruptedException {
		Thread.sleep(5000L);
		String services = "Service" + eurekaClient.getApplications();
		System.out.println(services);
		return services;
	}

}

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

}

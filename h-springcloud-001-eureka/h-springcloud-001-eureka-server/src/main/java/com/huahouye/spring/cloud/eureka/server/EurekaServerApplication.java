package com.huahouye.spring.cloud.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 参考 http://www.baeldung.com/spring-cloud-netflix-eureka
 * @author huahouye@gmail.com
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}

}

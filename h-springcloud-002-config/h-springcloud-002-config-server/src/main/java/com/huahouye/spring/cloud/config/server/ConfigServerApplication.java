package com.huahouye.spring.cloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 参考 https://spring.io/guides/gs/centralized-configuration/
 * 
 * @author huahouye@gmail.com
 *
 */
@SpringBootApplication
@EnableConfigServer // 开启 Spring Cloud Config 的服务端功能
public class ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}

}

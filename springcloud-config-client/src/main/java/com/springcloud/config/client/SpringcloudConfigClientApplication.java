package com.springcloud.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sunyelw
 */
@SpringBootApplication
@EnableScheduling
@RestController
public class SpringcloudConfigClientApplication {

	@Value("${server.port}")
	private String config;
	@Value("${eureka.client.serviceUrl.defaultZone}")
	private String eureka;

	@Value("${user.cron.name}")
	private String name;

	@Value("${user.cron.name.age}")
	private String age;

	@RequestMapping("/hello")
	public String hello() {
		return "hello . " + config;
	}

	@RequestMapping("/eureka")
	public String getEureka() {
		return "Hei, " + eureka;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudConfigClientApplication.class, args);
	}
}

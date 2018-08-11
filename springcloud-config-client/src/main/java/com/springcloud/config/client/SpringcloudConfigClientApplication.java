package com.springcloud.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sunyelw
 */
@SpringBootApplication
@EnableScheduling
@EnableEurekaClient
@RestController
public class SpringcloudConfigClientApplication {

	@Value("${eureka.server.port}")
	private String config;
	@Value("${eureka.client.serviceUrl.defaultZone}")
	private String eureka;

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

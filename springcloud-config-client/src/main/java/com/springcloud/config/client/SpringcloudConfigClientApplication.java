package com.springcloud.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Sunyelw
 */
@SpringBootApplication
@RestController
public class SpringcloudConfigClientApplication {

	@Value("${eureka.server.port}")
	private String config;

	@RequestMapping("/hello")
	public String hello() {
		return "hello . " + config;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudConfigClientApplication.class, args);
	}
}
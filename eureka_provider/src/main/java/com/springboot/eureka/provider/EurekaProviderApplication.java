package com.springboot.eureka.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sunyelw
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaProviderApplication {

	@RequestMapping("/")
	public String homeAll() {
		return "Hello world";
	}

	@Value("${server.port}")
	private String port;

	@RequestMapping("/home")
	public String home() {
		return "server port: " + port;
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaProviderApplication.class, args);
	}
}

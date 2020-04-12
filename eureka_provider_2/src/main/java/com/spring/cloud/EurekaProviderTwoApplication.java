package com.spring.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class EurekaProviderTwoApplication {

	@Value("${server.port}")
	private String port;

	@RequestMapping("/home")
	public String home() {
		return "server port: " + port;
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaProviderTwoApplication.class, args);
	}
}

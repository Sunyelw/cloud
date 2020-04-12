package com.springboot.eureka.provider;

import com.springboot.eureka.provider.config.AutoCompleteConfig;
import com.springboot.eureka.provider.config.AvoidScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

/**
 * @author Sunyelw
 *
 * @EnableCircuitBreaker 开启hystrix
 * @SpringCloudApplication 可以替换下面三个注解
 *
 */
@EnableCircuitBreaker
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {AvoidScan.class})})
@EnableConfigurationProperties({AutoCompleteConfig.class})
public class EurekaConsumeApplication {

	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumeApplication.class, args);
	}
}

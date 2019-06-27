package com.springboot.kafka.consumer.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class AsiaKafkaConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsiaKafkaConsumerApplication.class, args);
	}
}

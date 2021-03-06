package com.springcloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author Sunyelw
 */
@SpringBootApplication
@EnableConfigServer
public class AsiaConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsiaConfigServerApplication.class, args);
	}
}

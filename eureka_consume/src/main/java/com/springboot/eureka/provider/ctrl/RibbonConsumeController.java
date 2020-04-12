package com.springboot.eureka.provider.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 项目名称:   pinkstone
 * 包:        com.springboot.eureka.provider
 * 类名称:     RibbonConsumController
 * 类描述:     RestTemplate + Ribbon 实现负载均衡
 * 创建人:     huangyang
 * 创建时间:   2018/8/20 19:56
 */
@RestController
public class RibbonConsumeController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping(value = "/hello")
	public String hello() {
		return restTemplate.getForEntity("http://eureka-provider/home", String.class).getBody();
	}
}

package com.springboot.feignconsume;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 项目名称:   pinkstone
 * 包:        com.spring.cloud
 * 类名称:     HomeController
 * 类描述:     feign 实现负载均衡
 * 创建人:     huangyang
 * 创建时间:   2018/8/20 20:38
 */
@FeignClient("eureka-provider")
@Service
public interface HomeService {

	@GetMapping("/home")
	String home();
}

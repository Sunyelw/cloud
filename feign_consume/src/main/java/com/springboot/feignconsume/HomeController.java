package com.springboot.feignconsume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目名称:   pinkstone
 * 包:        com.springboot.feignconsume
 * 类名称:     HomeController
 * 类描述:
 * 创建人:     huangyang
 * 创建时间:   2018/8/20 20:53
 */
@RestController
public class HomeController {

	@Autowired
	private HomeService homeService;

	@RequestMapping("/home")
	public String home() {
		return homeService.home();
	}

}

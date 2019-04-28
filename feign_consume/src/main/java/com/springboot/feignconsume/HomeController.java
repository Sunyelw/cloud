package com.springboot.feignconsume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

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

	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH));
		System.out.println(cal.get(Calendar.DAY_OF_YEAR));
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
	}

}

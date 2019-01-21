package com.spring.springpracticethread.controller;

import com.spring.springpracticethread.service.IThreadHandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目名称:   pinkstone
 * 包:        com.spring.springpracticethread.controller
 * 类名称:     ThreadController
 * 类描述:     thread 主流程
 * 创建人:     huangyang
 * 创建时间:   2019/1/5 10:42
 */
@RestController
public class ThreadController {

	@Autowired
	private IThreadHandleService iThreadHandleService;

	@GetMapping("/hello")
	public String demo() {

		System.out.println("==================");

		iThreadHandleService.handle();

		return "hello";
	}


}

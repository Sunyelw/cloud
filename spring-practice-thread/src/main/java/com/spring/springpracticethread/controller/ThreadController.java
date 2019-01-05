package com.spring.springpracticethread.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.spring.springpracticethread.service.IThreadHandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 项目名称:   pinkstone
 * 包:        com.spring.springpracticethread.controller
 * 类名称:     ThreadController
 * 类描述:     thread 主流程
 * 创建人:     huangyang
 * 创建时间:   2019/1/5 10:42
 */
@Controller
public class ThreadController {

	@Autowired
	private IThreadHandleService iThreadHandleService;

	@GetMapping("/1")
	public void demo() {

		iThreadHandleService.handle();

	}


}

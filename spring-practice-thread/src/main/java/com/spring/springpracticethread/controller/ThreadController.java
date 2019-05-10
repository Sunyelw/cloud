package com.spring.springpracticethread.controller;

import com.spring.springpracticethread.service.IThreadHandleService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 项目名称:   pinkstone
 * 包:        com.spring.springpracticethread.controller
 * 类名称:     ThreadController
 * 类描述:     thread 主流程
 * 创建人:     huangyang
 * 创建时间:   2019/1/5 10:42
 */
@RestController
@Api(value = "二级用户中心 API", consumes = "application/json", produces = "application/json", protocols = "http")
public class ThreadController {

	@Autowired
	private IThreadHandleService iThreadHandleService;

	@RequestMapping(value = "/hello", produces = {"application/json"}, method = RequestMethod.POST)
	@ApiOperation(value = "Swagger Test", notes = "swagger demo", tags = {"Tool_swagger"})
	public String demo(@RequestBody SwaggerRq rq) {

		System.out.println("==================" + rq.getReq());

		iThreadHandleService.handle();

		return "hello";
	}


}

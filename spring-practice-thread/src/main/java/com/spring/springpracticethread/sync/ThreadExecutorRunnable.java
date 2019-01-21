package com.spring.springpracticethread.sync;

import com.spring.springpracticethread.service.IThreadService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 项目名称:   pinkstone
 * 包:        com.spring.springpracticethread.sync
 * 类名称:     ThreadExecutorRunnable
 * 类描述:     线程实现类
 * 创建人:     huangyang
 * 创建时间:   2019/1/5 10:40
 */
//@Component
@Slf4j
public class ThreadExecutorRunnable implements Runnable {

	private IThreadService iThreadService;

	private int i;

	private List<String> strList;

	public ThreadExecutorRunnable(IThreadService iThreadService, List<String> strList) {
		this.iThreadService = iThreadService;
		this.strList = strList;
	}

	@Override
	public void run() {

		log.error("thread {} start.........", Thread.currentThread().getName());

		for (String str : strList) {
			log.error("{} , hello {}", Thread.currentThread().getName(), str);
		}

//		iThreadService.printTest();

	}
}

package com.spring.springpracticethread.service.impl;

import com.spring.springpracticethread.service.IThreadHandleService;
import com.spring.springpracticethread.service.IThreadService;
import com.spring.springpracticethread.sync.ThreadExecutorRunnable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 项目名称:   pinkstone
 * 包:        com.spring.springpracticethread.service.impl
 * 类名称:     ThreadHandleServiceImpl
 * 类描述:     ThreadHandleServiceImpl
 * 创建人:     huangyang
 * 创建时间:   2019/1/5 10:37
 */
@Service
public class ThreadHandleServiceImpl implements IThreadHandleService {

	@Autowired
	private IThreadService iThreadService;

	@Override
	public void handle() {

		ExecutorService es = Executors.newFixedThreadPool(5);

		for (int i = 0; i < 10; i++) {
			es.execute(new ThreadExecutorRunnable(iThreadService, i));
		}

		es.shutdown();
	}
}

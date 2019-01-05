package com.spring.springpracticethread.service.impl;

import com.spring.springpracticethread.service.IThreadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 项目名称:   pinkstone
 * 包:        com.spring.springpracticethread.service.impl
 * 类名称:     ThreadServiceImpl
 * 类描述:     thread practice impl
 * 创建人:     huangyang
 * 创建时间:   2019/1/5 10:36
 */
@Service
@Slf4j
public class ThreadServiceImpl implements IThreadService {

	@Override
	public void printTest() {
		log.error("thread Id: {}, thread name: {}",
				Thread.currentThread().getId(), Thread.currentThread().getName());
	}
}

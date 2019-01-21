package com.spring.springpracticethread.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/**
 * 项目名称:   pinkstone
 * 包:        com.spring.springpracticethread.sync
 * 类名称:     ThreadExecutorCallable
 * 类描述:     callable
 * 创建人:     huangyang
 * 创建时间:   2019/1/5 21:32
 */
@Slf4j
public class ThreadExecutorCallable implements Callable<Integer> {

	private int i;

	private Set set = new HashSet();

	public ThreadExecutorCallable(Set set, int i) {
		this.set = set;
		this.i = i;
	}

	@Override
	public Integer call() throws Exception {
		System.out.println(i);
//		List<String> list = new ArrayList<>();
//		for (String str : strList) {
//			log.error("{} : world {}", Thread.currentThread().getName(), str);
//			list.add(str);
//		}
		this.set.add(i);
		return i;
	}
}

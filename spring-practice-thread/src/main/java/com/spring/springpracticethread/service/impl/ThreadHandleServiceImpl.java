package com.spring.springpracticethread.service.impl;

import com.spring.springpracticethread.service.IThreadHandleService;
import com.spring.springpracticethread.service.IThreadService;
import com.spring.springpracticethread.sync.ThreadExecutorCallable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 项目名称:   pinkstone
 * 包:        com.spring.springpracticethread.service.impl
 * 类名称:     ThreadHandleServiceImpl
 * 类描述:     ThreadHandleServiceImpl
 * 创建人:     huangyang
 * 创建时间:   2019/1/5 10:37
 */
@Slf4j
@Service
public class ThreadHandleServiceImpl implements IThreadHandleService {

	@Autowired
	private IThreadService iThreadService;

	@Override
	public void handle() {

		ExecutorService es = Executors.newFixedThreadPool(5);
		List<FutureTask<List<String>>> fts = new ArrayList<>();

		List<String> strList = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
//			strList.add("a" + i);
//			FutureTask<List<String>> ft = new FutureTask<>(new ThreadExecutorCallable(strList, i));
//			fts.add(ft);
//			es.submit(ft);
//			if (strList.size() == 2) {
//				log.error("size: {}", strList.size());
//				x
//				strList.clear();
//			}
		}

//		if (strList.size() != 0) {
//			log.error("last size: {}", strList.size());
//			FutureTask<List<String>> ft = new FutureTask<>(new ThreadExecutorCallable(strList));
//			fts.add(ft);
//			es.submit(ft);
//			strList.clear();
//		}
//
//		List<String> t = new ArrayList<>();
//		for (FutureTask<List<String>> ft : fts) {
//			try {
//				List<String> tmp = ft.get();
//				if (null != tmp && !tmp.isEmpty()) {
//					t.addAll(tmp);
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//
//		for (String s : t) {
//			System.out.println("String: " + s);
//		}

		es.shutdown();
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService es = Executors.newFixedThreadPool(5);
		Set set = new HashSet();
		FutureTask<Integer> ft = null;
		List<FutureTask> ftlist = new ArrayList();
		for (int i = 0; i < 1000; i++) {
			ft = new FutureTask<>(new ThreadExecutorCallable(set, i));
			ftlist.add(ft);
			es.submit(ft);
		}

		for (FutureTask task : ftlist) {
			task.get();
		}
		System.out.println("=======================================" + set.size());
	}
}

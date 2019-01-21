package com.spring.springpracticethread.execute;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称:   pinkstone
 * 包:        com.spring.springpracticethread.execute
 * 类名称:     MultiThread
 * 类描述:     multiple thread execte
 * 创建人:     huangyang
 * 创建时间:   2019/1/6 14:54
 */
@RestController
@Slf4j
public class MultiThread {

	@GetMapping("/aa")
	public void main(String[] args) {

		List<String> strList = new ArrayList<>();
		strList.add("a1");
		strList.add("a2");
		strList.add("a3");
		strList.add("a4");

		Th1 th1 = new Th1(strList);
		Th2 th2 = new Th2(strList);

		th1.start();
		th2.start();

	}

	private class Th1 extends Thread {

		private List<String> strList;

		public Th1(List<String> strList) {
			this.strList = strList;
		}

		@Override
		public void run() {
			for (String str : strList) {
				log.error("{} execute {}", Thread.currentThread().getName(), str);
			}
		}
	}

	private class Th2 extends Thread {

		private List<String> strList;

		public Th2(List<String> strList) {
			this.strList = strList;
		}

		@Override
		public void run() {
			for (String str : strList) {
				strList.remove(str);
			}
		}
	}

}

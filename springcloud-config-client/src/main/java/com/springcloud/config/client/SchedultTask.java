package com.springcloud.config.client;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 项目名称:   pinkstone
 * 包:        com.springcloud.config.client
 * 类名称:     AA
 * 类描述:     ss
 * 创建人:     huangyang
 * 创建时间:   2018/8/7 20:22
 */
@Component
@Slf4j
public class SchedultTask {

	@Scheduled(cron = "0/5 * *  * * ?")
	public void tasks() {
		log.info("now is:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}

	/**
	 * 6位随机二维码 纯数字
	 * @param args
	 */
	public static void main(String[] args) {
		Set<Integer> codes = new HashSet<>();
		Random random = new Random();
		for (int i = 0; i < i + 1; i++) {
			if (codes.size() == 6) {
				break;
			} else {
				codes.add(random.nextInt(10));
			}
		}
		System.out.println(StringUtils.join(codes.toArray()));
	}
}

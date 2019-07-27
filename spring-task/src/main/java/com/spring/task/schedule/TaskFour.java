package com.spring.task.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 项目名称:   pinkstone
 * 包:        com.spring.task.schedule
 * 类名称:     TaskOne
 * 类描述:     task one
 * 创建人:     huangyang
 * 创建时间:   2019/4/8 18:54
 */
@Component
public class TaskFour {

    private ExecutorService es = Executors.newFixedThreadPool(10);

    @Scheduled(cron = "0/1 * * * * ?")
    public void taskFour() {

        System.out.println("*****************");
        show();

    }

    private void show(){

        ExecutorService es = Executors.newFixedThreadPool(10);

        es.execute(() -> System.out.println(Thread.currentThread().getId() + " == start..."));
        es.shutdown();


    }

}

package com.springboot.kafka.producer.two;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * 项目名称:   pinkstone
 * 包:        com.springboot.kafka.producer.two
 * 类名称:     Listener
 * 类描述:     topic listener
 * 创建人:     huangyang
 * 创建时间:   2019/5/3 12:39
 */
@Component
@Slf4j
public class Listener {

    private final CountDownLatch latch1 = new CountDownLatch (1);

    @KafkaListener(topics = "sunic")
    public void listen(String foo) {

        log.error ("Listen_Topic {} message: {}", "sunic", foo);

        this.latch1.countDown ();
    }

}

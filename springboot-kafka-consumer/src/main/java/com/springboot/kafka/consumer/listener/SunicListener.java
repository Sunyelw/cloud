package com.springboot.kafka.consumer.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 项目名称:   pinkstone
 * 包:        com.springboot.kafka.consumer.listener
 * 类名称:     SunicListener
 * 类描述:     topic: sunic 监听
 * 创建人:     huangyang
 * 创建时间:   2019/4/29 2:34
 */
@Component
@Slf4j
public class SunicListener {

    @KafkaListener(topics = "sunic")
    public void sunTopicListener(String message) {

        log.error("kafka topic: {}, message: {}", "sunic", message);

//        ack.acknowledge();
    }

}

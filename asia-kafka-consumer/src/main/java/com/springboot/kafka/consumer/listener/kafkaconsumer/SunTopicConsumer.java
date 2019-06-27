package com.springboot.kafka.consumer.listener.kafkaconsumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 项目名称:   pinkstone
 * 包:        com.springboot.kafka.consumer.listener.kafkaconsumer
 * 类名称:     SunTopicConsumer
 * 类描述:     sun-topic
 * 创建人:     huangyang
 * 创建时间:   2019/6/27 16:40
 */
@Component
@Slf4j
public class SunTopicConsumer {

    @KafkaListener(topics = {"sun-topic"}, containerFactory = "secKafkaListenerContainerFactory")
    public void sunListener(List<ConsumerRecord<String, String>> list, Acknowledgment ack) {

        for (ConsumerRecord<String, String> record : list) {

            log.error("topic: {}", record.topic());
            log.error("partition: {}", record.partition());
            log.error("offset: {}", record.offset());
            log.error("value: {}", record.value());

            ack.acknowledge();
        }
    }

}

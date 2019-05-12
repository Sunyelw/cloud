package com.springboot.kafka.producer.three;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

/**
 * 项目名称:   pinkstone
 * 包:        com.springboot.kafka.producer.three
 * 类名称:     P1
 * 类描述:     拦截器 1
 * 创建人:     huangyang
 * 创建时间:   2019/5/12 10:16
 */
public class P1 implements ProducerInterceptor<Integer, String> {

    @Override
    public ProducerRecord <Integer, String> onSend(ProducerRecord <Integer, String> producerRecord){
        return null;
    }

    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e){

    }

    @Override
    public void close(){

    }

    @Override
    public void configure(Map<String, ?> map){

    }
}

package com.springboot.kafka.producer.pojo;

import lombok.Builder;
import lombok.Data;

/**
 * 项目名称:   pinkstone
 * 包:        com.springboot.kafka.producer.pojo
 * 类名称:     SendRecord
 * 类描述:      发送对象
 * 创建人:     huangyang
 * 创建时间:   2019/5/11 17:06
 */
@Builder(toBuilder = true)
@Data
public class KafkaSendRecordReq {

    private String topic;

    private int partition;

    private int key;

    private String message;

}

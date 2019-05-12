package com.springboot.kafka.producer.pojo;

import lombok.Data;

/**
 * 项目名称:   pinkstone
 * 包:        com.springboot.kafka.producer.pojo
 * 类名称:     kafkaSendRecordResp
 * 类描述:     发送结果
 * 创建人:     huangyang
 * 创建时间:   2019/5/11 17:10
 */
@Data
public class KafkaSendRecordResp {

    private String respCode;

    private String respMsg;

    private String topic;
    private int partition;
    private long offset;
    private long timestamp;


    public KafkaSendRecordResp() {
        this.respCode = "16000";
        this.respMsg = "SUCCESS";
    }
}

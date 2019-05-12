package com.springboot.kafka.producer.three;

import com.springboot.kafka.producer.pojo.KafkaSendRecordReq;
import com.springboot.kafka.producer.pojo.KafkaSendRecordResp;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目名称:   pinkstone
 * 包:        com.springboot.kafka.producer.three
 * 类名称:     KafkaWithBoot
 * 类描述:     Even Quicker, with Spring Boot
 * 创建人:     huangyang
 * 创建时间:   2019/5/3 13:23
 */
@RestController
@Slf4j
public class KafkaWithBoot {

    @Autowired
    private KafkaTemplate<Integer, String> kafkaBoot;

    // ListenableFutureCallback

    @PostMapping(value = "/send", produces = {"application/json"}, consumes = {"application/json"})
    @ApiOperation(value = "发送kafka消息", notes = "发送kafka消息", httpMethod = "POST", response = KafkaSendRecordResp.class)
    public KafkaSendRecordResp sendKafka(@ApiParam(value = "发送消息体", required = true) @RequestBody KafkaSendRecordReq req) {

        KafkaSendRecordResp resp = new KafkaSendRecordResp();

        try {
            ListenableFuture<SendResult<Integer, String>> future =
                    kafkaBoot.send(req.getTopic(), req.getPartition(), req.getKey(), req.getMessage());
            future.addCallback (new ListenableFutureCallback<SendResult<Integer, String>> () {

                @Override
                public void onSuccess(SendResult<Integer, String> result) {
                    RecordMetadata metadata = result.getRecordMetadata();
                    ProducerRecord<Integer, String> record = result.getProducerRecord();
                    resp.setPartition(record.partition());
                    resp.setTopic(record.topic());
//                    resp.setOffset(record.offset());
                    resp.setTimestamp(record.timestamp());

                    log.error ("Send SUCCESS: {}", record.value());
                }

                @Override
                public void onFailure(Throwable ex) {
                    log.error ("Send ERROR: {}", ex.getMessage (), ex);
                }

            });
        } catch (Exception e) {
            resp.setRespCode("16009");
            resp.setRespMsg(e.getMessage());
            e.printStackTrace();
        }

        return resp;
    }

    public void sendKafka(){

        log.error("TEST");
    }
}

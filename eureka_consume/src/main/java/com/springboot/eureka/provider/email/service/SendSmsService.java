package com.springboot.eureka.provider.email.service;

import com.springboot.eureka.provider.config.FeignClientConfig;
import com.springboot.eureka.provider.dto.SendSmsRequest;
import com.springboot.eureka.provider.dto.SendSmsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 项目名称:   pinkstone
 * 包:        com.migu.pinkstone.service
 * 类名称:     SendSmsService
 * 类描述:     发送短信 Eureka 注入
 * 创建人:     huangyang
 * 创建时间:   2019/4/3 10:13
 */
@FeignClient(value = "SMS", configuration = FeignClientConfig.class)
public interface SendSmsService {

    @RequestMapping(value = "/sms/sendSms", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    SendSmsResponse sendSms(SendSmsRequest req);
}

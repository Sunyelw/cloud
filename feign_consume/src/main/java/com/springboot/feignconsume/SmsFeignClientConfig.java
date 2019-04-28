package com.springboot.feignconsume;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.commons.configuration.SystemConfiguration;
import org.springframework.stereotype.Component;

/**
 * 项目名称:   pinkstone
 * 包:        com.migu.pinkstone.util
 * 类名称:     SmsFeignClientConfig
 * 类描述:     feignClient config
 * 创建人:     huangyang
 * 创建时间:   2019/4/4 17:13
 */
@Component
public class SmsFeignClientConfig implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("CommonConst.SmsHeader", "helloWorld");
        requestTemplate.header("THREAD_NAME", Thread.currentThread().getName());
    }
}

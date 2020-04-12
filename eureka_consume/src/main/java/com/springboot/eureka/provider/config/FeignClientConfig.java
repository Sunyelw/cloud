package com.springboot.eureka.provider.config;

import com.springboot.eureka.provider.email.service.SmsHandleUtil;
import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 项目名称:   pinkstone
 * 包:        com.springboot.eureka.provider.config
 * 类名称:     FeignClientConfig
 * 类描述:     feignClien config
 * 创建人:     huangyang
 * 创建时间:   2019/4/4 17:13
 */
@Component
public class FeignClientConfig implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("sourceDeviceCode", "100001");
        try {
            requestTemplate.header("authenticatorSource",
                    SmsHandleUtil.encryptAES(
                            "9a693e9333c615470690d73016cb312afea8f4d1f423f106642c0f75beaa10b9 " + tranDate()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String tranDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(new Date());
    }

    /**
     * 配置日志级别, 不打印 SynchronousMethodHandler#executeAndDecode 有线程阻塞问题
     * @return
     */
    @Bean
    Logger.Level getLevel() {
        return Logger.Level.NONE;
    }
}

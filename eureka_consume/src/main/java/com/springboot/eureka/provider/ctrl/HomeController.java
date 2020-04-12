package com.springboot.eureka.provider.ctrl;

import com.springboot.eureka.provider.api.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 项目名称:   pinkstone
 * 包:        com.springboot.eureka.provider.ctrl
 * 类名称:     HomeController
 * 类描述:     ss
 * 创建人:     huangyang
 * 创建时间:   2019/4/11 9:01
 */
@RestController
@Slf4j
public class HomeController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/one")
    public String hm() {

        log.error("start: {}", new SimpleDateFormat("HHmmssSSS").format(new Date()));
        String resp = helloService.home();

        log.error("Hello_Resp:" + resp);

        return resp;

    }
}

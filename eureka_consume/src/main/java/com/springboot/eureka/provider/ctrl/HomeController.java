package com.springboot.eureka.provider.ctrl;

import com.springboot.eureka.provider.api.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class HomeController {

    private Logger logger = LoggerFactory.getLogger(HomeController.class);

    private final HelloService helloService;

    @Autowired
    public HomeController(@Qualifier("helloService") HelloService helloService){
        this.helloService = helloService;
    }

    @RequestMapping("/one")
    public String hm() {
//        ExtendedLogger lg = LogManager.getContext().getLogger(HomeController.class.getName());
//        lg.error("From extended logger...");
//
//        ExtendedLogger xyz = LogManager.getContext().getLogger("x.y");
//        xyz.debug("Debug From x.y");

        logger.info("++++++++++++++");
        logger.info("++++++++++++++");

        logger.error("start: {}", new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()));
        String resp = helloService.home();

        logger.error("Hello_Resp:" + resp);

        return resp;
    }
}

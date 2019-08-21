package com.spring.springweb;

import com.spring.project.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目名称:   pinkstone
 * 包:        com.spring.springweb
 * 类名称:     Hw
 * 类描述:     hw
 * 创建人:     huangyang
 * 创建时间:   2019/8/19 20:33
 */
@RestController
public class Hw {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hw")
    public String hw() {
        return helloService.sayHello();
    }

}

package com.springboot.eureka.provider.ctrl;

import com.springboot.eureka.provider.api.HelloService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.status.StatusLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
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

    private Logger logger = LoggerFactory.getLogger(LogManager.ROOT_LOGGER_NAME);

    private final static StatusLogger STATUS_LOGGER = StatusLogger.getLogger();

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

    @RequestMapping("/a")
    public String one() {
        LoggerFactory.getLogger(HomeController.class).info("{} - info - msg", logger.getClass().getName());
        STATUS_LOGGER.info("{} - info - msg", STATUS_LOGGER.toString());
        return "<h1>.....................</h1>";
    }

    public static void main(String[] args) throws InterruptedException{

        new Thread(() -> run("abc", false)).start();
        Thread.sleep(1000);
        new Thread(() -> run("def", true)).start();

    }

//    private ThreadLocal<Logger> loggerThreadLocal = new ThreadLocal <>();

    private static void run(String str, boolean isGC) {

        try {
            ThreadLocal<String> th = new ThreadLocal <>();
            th.set(str);

            if (isGC) {
                System.out.println("gc");
                System.gc();
            }

            // 获取 ThreadLocalMap
            Thread t = Thread.currentThread();
            Field thMapField = t.getClass().getDeclaredField("threadLocals");
            thMapField.setAccessible(true);
            Object thMapObj = thMapField.get(t);

            // 获取size
            Field sizeField = thMapObj.getClass().getDeclaredField("size");
            sizeField.setAccessible(true);
            int size = (int) sizeField.get(thMapObj);

            System.out.println("size: " + size);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

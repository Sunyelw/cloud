package com.springboot.eureka.provider.config;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.async.AsyncQueueFullPolicy;
import org.apache.logging.log4j.core.async.EventRoute;

/**
 * 项目名称:   pinkstone
 * 包:        com.springboot.eureka.provider.config
 * 类名称:     EnqueueAsyncQueueFullPolicy
 * 类描述:     异步队列满时处理策略
 * 创建人:     huangyang
 * 创建时间:   2020/4/14 14:37
 */
public class EnqueueAsyncQueueFullPolicy implements AsyncQueueFullPolicy {

    @Override
    public EventRoute getRoute(long backgroundThreadId, Level level){
        return EventRoute.ENQUEUE;
    }
}

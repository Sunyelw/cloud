package com.springboot.eureka.provider.dto;


import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 类作用：JSON转换工具类.
 * 项目名称:  pinkstone-common
 * 包:        com.migu.pinkstone.common.util
 * 类名称:    JsonUtil.java
 * 类描述:    JSON转换工具类
 * 创建人:    wanngcheng3
 * 创建时间:  2017-12-4 11:46
 */
public class JsonUtil {
    private static final Logger LOG = LoggerFactory.getLogger(JsonUtil.class);

    /**
     * stringToObject.
      *〈一句话功能简述〉
      *〈功能详细描述〉
      * @return 1
      * @param source 1
      * @param tClass 1
      * @param <T>  source,tClass
     */
    public static <T> T stringToObject(String source, Class<T> tClass) {
        try {
            if (source == null) {
                return null;
                }
            return JSON.parseObject(source,tClass);

        } catch (Exception e) {
            if (LOG.isErrorEnabled()){
                LOG.error("JsonUtil.stringToObject  error:",e.getMessage());
            }
        }
        return null;
    }

    /**
     * objectToString.
      *〈一句话功能简述〉
      *〈功能详细描述〉
      * @param object object
      * @return 1
     */
    public static String objectToString(Object object) {
        try {
            if (object != null) {
                return JSON.toJSONString(object);
            }
            return null;
        } catch (Exception e) {
            if (LOG.isErrorEnabled()){
                LOG.error("JsonUtil.stringToObject  error:",e.getMessage());
            }
        }
        return null;
    }

    public static Map jsonStringToMap(String s) {
        if(StringUtils.isNotEmpty(s)) {
            Map map = (Map) JSON.parse(s);
            if (map != null) {
                return map;
            }
            return null;
        }
        return null;
    }

}

package com.springboot.database.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 项目名称:   pinkstone
 * 包:        com.springboot.database.util
 * 类名称:     DbUtils
 * 类描述:     database util
 * 创建人:     huangyang
 * 创建时间:   2019/1/23 17:06
 */
@Slf4j
public class DbUtils {

    /**
     * only datasource
     */
    private static DruidDataSource dataSource;

    /**
     * 初始化数据源
     */
    public static void init() {

        try {

            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUrl("jdbc://localhost:3306/nycat");
            dataSource.setUsername("root");
            dataSource.setPassword("root");
            dataSource.setTestOnBorrow(false);
            dataSource.setTestWhileIdle(true);

        } catch (Exception e) {
            log.error("create datasource error: {}", e.getMessage(), e);
        }
    }

    /**
     * 获取连接
     * @return
     */
    public static Connection getConnection() {

        if (null != dataSource) {
            try {
                return dataSource.getConnection();
            } catch (SQLException e) {
                log.error("get conn error: {}", e.getMessage(), e);
            }
        }

        return null;
    }
}

package com.springboot.database.service.impl;

import com.springboot.database.service.IShowService;
import com.springboot.database.util.DbUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 项目名称:   pinkstone
 * 包:        com.springboot.database.service.impl
 * 类名称:     IShowServiceImpl
 * 类描述:     show impl
 * 创建人:     huangyang
 * 创建时间:   2019/1/23 16:04
 */
@Service
@Slf4j
public class IShowServiceImpl implements IShowService {


    @Override
    @Transactional
    public void handleData() {

        try {

            DbUtils.init();
            Connection conn = DbUtils.getConnection();

            if (null == conn) {
                log.error("conn is null...");
                return;
            }

            String sql = "select * from user where id = ?";

            PreparedStatement ptst = conn.prepareStatement(sql);
            ptst.setString(1, "1");

            ResultSet rs = ptst.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
            }

            conn.close();

            if (true) {
                throw new Exception();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

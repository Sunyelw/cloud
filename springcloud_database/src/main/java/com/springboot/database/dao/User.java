package com.springboot.database.dao;

import lombok.Data;

import java.util.Date;

/**
 * 项目名称:   pinkstone
 * 包:        com.springboot.database.dao
 * 类名称:     User
 * 类描述:		shiro_demo database u_user table
 * 创建人:     huangyang
 * 创建时间:   2018/8/23 20:54
 */
@Data
public class User {

	private Integer id;

	private String nickName;

	private String email;

	private String pswd;

	private Date createTime;

	private Date lastLoginTime;

	private int status;
}

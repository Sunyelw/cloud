package com.springboot.database.sddata;

import com.springboot.database.dao.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 项目名称:   pinkstone
 * 包:        com.springboot.database.sddata
 * 类名称:     UserMapper
 * 类描述:     u_user mapper
 * 创建人:     huangyang
 * 创建时间:   2018/8/23 20:56
 */
@Mapper
public interface UserMapper {

	@Insert("insert into u_user " +
			"values(null, #{user.nickName}, #{user.email}, #{user.pswd}" +
			",#{user.createTime}, #{user.lastLoginTime}, #{user.status})")
	int insertUser(@Param("user") User user);
}

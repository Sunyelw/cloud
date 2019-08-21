package com.springboot.database.controller;

import com.springboot.database.dao.Student;
import com.springboot.database.dao.User;
import com.springboot.database.sddata.UserMapper;
import com.springboot.database.service.IShowService;
import com.springboot.database.smdata.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 项目名称:   pinkstone
 * 包:        com.springboot.database.controller
 * 类名称:     MulitDataController
 * 类描述:     多数据源测试
 * 创建人:     huangyang
 * 创建时间:   2018/8/23 20:52
 */
@RestController
public class MulitDataController {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private StudentMapper studentMapper;

	@Autowired
	private IShowService iShowService;

	@RequestMapping("/insa")
	public String ins() {
		User user = new User();
		user.setId(null);
		user.setCreateTime(new Date());
		user.setEmail("11@qq.com");
		user.setLastLoginTime(new Date());
		user.setStatus(1);
		int i = userMapper.insertUser(user);
		return i + user.toString();
	}

	@RequestMapping("/insb")
	public String insb() {
		Student s = new Student();
		s.setAge(100);
		s.setBirthDate(new Date());
		s.setId(null);
		s.setName("sun");
		int i = studentMapper.insertStudent(s);
		return i + s.toString();
	}

	@RequestMapping("/test")
	public String show() {

		iShowService.handleData();

		return "success";
	}
}

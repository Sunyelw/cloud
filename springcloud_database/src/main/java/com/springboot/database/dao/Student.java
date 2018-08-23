package com.springboot.database.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目名称:   pinkstone
 * 包:        com.asiainfo.boot.dao
 * 类名称:     Student
 * 类描述:     student table dao
 * 创建人:     huangyang
 * 创建时间:   2018/7/28 22:23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable{


	private static final long serialVersionUID = -9204128596814773887L;

	private Integer id;

	private int age;

	private String name;

	private Date birthDate;

}

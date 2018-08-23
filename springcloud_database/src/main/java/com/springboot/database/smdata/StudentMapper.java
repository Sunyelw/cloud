package com.springboot.database.smdata;

import com.springboot.database.dao.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 项目名称:   pinkstone
 * 包:        com.asiainfo.boot.smdata
 * 类名称:     StudentMapper
 * 类描述:     Student Mapper
 * 创建人:     huangyang
 * 创建时间:   2018/7/28 22:28
 */
@Mapper
public interface StudentMapper {

	@Insert("insert into student " +
			"values(null, #{student.age}, #{student.name}, #{student.birthDate})")
	int insertStudent(@Param("student") Student student);

	@Select("select * from student where id = #{id}")
	Student selectStudent(@Param("id") int id);
}

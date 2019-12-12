package com.mybatis.courses.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.mybatis.courses.entities.Teacher;


@Mapper
@Repository
public interface TeacherMapper {

	@Select("select t.id, t.name from teachers t")
	@Results(value = { 
			@Result(property = "id", column = "id"), 
			@Result(property = "name", column = "name") })
	public List<Teacher> getAll();

}

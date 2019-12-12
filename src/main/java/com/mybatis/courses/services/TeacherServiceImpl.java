package com.mybatis.courses.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.courses.entities.Teacher;
import com.mybatis.courses.mappers.TeacherMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TeacherServiceImpl implements ITeacherService {

	@Autowired
	private TeacherMapper teacherMapper;

	@Override
	public List<Teacher> getAll() {
		log.info("Init getAll...");
		
		return teacherMapper.getAll();
	}
	
	
}

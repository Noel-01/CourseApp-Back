package com.mybatis.courses.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.courses.dto.CourseDto;
import com.mybatis.courses.entities.Course;
import com.mybatis.courses.entities.Page;
import com.mybatis.courses.exceptions.ElementExistException;
import com.mybatis.courses.exceptions.ElementNoExistException;
import com.mybatis.courses.mappers.CourseMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CourseServiceImpl implements ICourseService {
	
	@Autowired 
	private CourseMapper courseMapper;
	
	@Autowired
	private IPageService pageSevice;

	
	@Override
	public Course create(Course course) throws ElementExistException {
		log.info("Init create...");
		
		if(courseMapper.findByName(course.getTitle()) != null) {
			throw new ElementExistException("The record already exists");
		}
		courseMapper.insert(course);
		log.info("Create course Title -> " + course.getTitle());
		return course;
	}



	@Override
	public Page findActiveCourses(int pag) throws ElementNoExistException{
		log.info("Init findActiveCourses...");
		
		Page page = pageSevice.getPage(pag);
		
		if(page == null) {
			throw new ElementNoExistException("Page does not exist");
		}

		List<CourseDto> list = courseMapper.findActiveCourses(page.getLimit1(), 5);
		page.setList(list);
		
		return page;
	}

	@Override
	public Course findById(Long id) throws ElementNoExistException {
		log.info("Init findById...");
		
		Course course = courseMapper.findById(id);
		if(course == null) {
			throw new ElementNoExistException("There is no record");
		}
		return course;
	}

}
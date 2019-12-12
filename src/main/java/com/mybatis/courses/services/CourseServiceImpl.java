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
		if(courseMapper.findByName(course.getTitle()) != null) {
			throw new ElementExistException("El registro ya existe");
		}
		courseMapper.insert(course);
		return course;
	}



	@Override
	public Page findActiveCourses(int pagina) throws ElementNoExistException{
		
		Page page = pageSevice.paginaPide(pagina);
		
		if(page == null) {
			throw new ElementNoExistException("No existe la página");
		}

		List<CourseDto> list = courseMapper.findActiveCourses(pagina, 5);
		list.sort((x,y)-> x.getTitle().compareTo(y.getTitle()));
		page.setList(list);
		
		return page;
	}

	@Override
	public Course findById(Long id) throws ElementNoExistException {
		Course course = courseMapper.findById(id);
		if(course == null) {
			throw new ElementNoExistException("No existe el registro");
		}
		return course;
	}

}
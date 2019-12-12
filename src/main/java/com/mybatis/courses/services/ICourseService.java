package com.mybatis.courses.services;

import com.mybatis.courses.entities.Course;
import com.mybatis.courses.entities.Page;

public interface ICourseService {

	Course create(Course course);

	Page findActiveCourses(int pagina);

	Course findById(Long id);
}
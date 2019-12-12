package com.mybatis.courses.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.mybatis.courses.dto.CourseDto;
import com.mybatis.courses.entities.Course;


@Mapper
@Repository
public interface CourseMapper {

	@Insert("insert into courses(title, level, hours, teacherid, state) values(#{title}, #{level}, #{hours}, #{teacherid}, #{state})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	public int insert(Course course);

	
	@Select("select c.id, c.title, c.level, c.hours, t.name, c.state from courses c inner "
			+ "join teachers t on c.teacherid = t.id where c.state = true order by c.title limit #{pagenum}, #{contentnum}")
	@Results(value = { 
			@Result(property = "title", column = "title"),
			@Result(property = "level", column = "level"),
			@Result(property = "hours", column = "hours"),
			@Result(property = "teacherName", column = "name"), 
			@Result(property = "state", column = "state") })
	public List<CourseDto> findActiveCourses(@Param("pagenum") int pagenum, @Param("contentnum") int contentnum);
	
	
	@Select("select count(c.id) num from courses c inner join teachers t on c.teacherid = t.id where c.state = true")
	public int findCourses();
	

	@Select("select c.id, c.title, c.level, c.hours, c.teacherid, c.state from courses c where c.id = #{id}")
	@Results(value = { 
			@Result(property = "id", column = "id"), 
			@Result(property = "title", column = "title"),
			@Result(property = "level", column = "level"), 
			@Result(property = "hours", column = "hours"),
			@Result(property = "teacherid", column = "teacherid"), 
			@Result(property = "state", column = "state") })
	public Course findById(@Param("id") Long id);
	
	
	@Select("select c.id, c.title, c.level, c.hours, c.teacherid, c.state from courses c where c.title = #{title}")
	@Results(value = { 
			@Result(property = "id", column = "id"), 
			@Result(property = "title", column = "title"),
			@Result(property = "level", column = "level"), 
			@Result(property = "hours", column = "hours"),
			@Result(property = "teacherid", column = "teacherid"), 
			@Result(property = "state", column = "state") })
	public Course findByName(@Param("title") String title);

}

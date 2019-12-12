package com.mybatis.courses.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {

	private String title;
	private String level;
	private int hours;
	private String teacherName;
	private Boolean state;
		
}

package com.mybatis.courses.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CourseDto {

	private String title;
	private String level;
	private int hours;
	private String teacherName;
	private Boolean state;
		
}

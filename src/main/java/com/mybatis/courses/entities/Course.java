package com.mybatis.courses.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Course {

	private Long id;
	private String title;
	private String level;
	private int hours;
	private int teacherid;  
	private Boolean state;

}

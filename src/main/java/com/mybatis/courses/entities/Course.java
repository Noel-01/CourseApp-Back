package com.mybatis.courses.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {

	private Long id;
	private String title;
	private String level;
	private int hours;
	private int teacherid;  
	private Boolean state;

}

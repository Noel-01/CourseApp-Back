package com.mybatis.courses.entities;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Page {

	private int totalPaginas;
	private int paginaActual;
	private List<?> list;
	private int limit1;
	
}

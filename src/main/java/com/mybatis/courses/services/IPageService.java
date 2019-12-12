package com.mybatis.courses.services;

import com.mybatis.courses.entities.Page;

public interface IPageService {

	int totalPaginas();
	
	Page paginaPide(int paginaPide);
}
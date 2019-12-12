package com.mybatis.courses.services;

import com.mybatis.courses.entities.Page;

public interface IPageService {

	int totalPages();
	
	Page getPage(int paginaPide);
	
	Page calculateLimits(int paginaPide);
}
package com.mybatis.courses.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.courses.entities.Page;
import com.mybatis.courses.mappers.CourseMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PageServiceImpl implements IPageService{
	
	@Autowired
	private CourseMapper mapper;
	
	
	@Override
	public int totalPaginas() { 
		int num = mapper.findCourses() / 5;
		return num;
	}
	
	@Override
	public Page paginaPide(int paginaPide) {
		Page page = calculeLimits(paginaPide);
		page.setPaginaActual(paginaPide);
		page.setTotalPaginas(totalPaginas());
		if(paginaPide >= 0 && paginaPide <= page.getTotalPaginas()) {
			return page;
		}
		return null;
	}
	public Page calculeLimits(int paginaPide) {
		int limit1 = 0;
		Page page = new Page();
		if(paginaPide == 0) {
			limit1 = (paginaPide * 5) + paginaPide;
		}else {
			limit1 = paginaPide * 5;
		}
		
		int limit2 = limit1 + 5;
		page.setLimit1(limit1);
		page.setLimit2(limit2);
		return page;
	}
}
	
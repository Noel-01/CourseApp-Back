package com.mybatis.courses.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.courses.entities.Page;
import com.mybatis.courses.mappers.CourseMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PageServiceImpl implements IPageService {

	@Autowired
	private CourseMapper mapper;

	@Override
	public int totalPages() {
		log.info("Init totalPages...");
		
		return mapper.findCourses() / 5;
	}

	@Override
	public Page getPage(int pag) {
		log.info("Init getPage...");
		
		Page page = calculateLimits(pag);
		page.setPaginaActual(pag);
		page.setTotalPaginas(totalPages());
		
		if (pag >= 0 && pag <= page.getTotalPaginas()) {
			return page;
		}
		
		return null;
	}

	@Override
	public Page calculateLimits(int pag) {
		log.info("Init calculateLimits...");
		
		int limit1;

		if (pag == 0) {
			limit1 = (pag * 5) + pag;
		} else {
			limit1 = pag * 5;
		}

		Page page = new Page();
		page.setLimit1(limit1);
		return page;
	}
}

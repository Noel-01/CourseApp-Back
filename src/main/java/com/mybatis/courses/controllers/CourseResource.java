package com.mybatis.courses.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.mybatis.courses.entities.Course;
import com.mybatis.courses.entities.Page;
import com.mybatis.courses.services.ICourseService;


@Component
@Path("/course")
public class CourseResource {
	
	@Autowired
	private ICourseService cursoService;

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(@RequestBody Course course) {
		return Response.ok().entity(cursoService.create(course)).build();
	}
	

	@GET
	@Path("/activeCourses/{page}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findActiveCourses(@PathParam("page") int pag) {
		return Response.ok().entity(cursoService.findActiveCourses(pag)).build();
	}

}
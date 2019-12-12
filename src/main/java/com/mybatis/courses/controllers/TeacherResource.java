package com.mybatis.courses.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mybatis.courses.services.ITeacherService;


@Component
@Path("/teachers")
public class TeacherResource {
	
	@Autowired
	private ITeacherService teacherService;
	
	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		return Response.ok().entity(teacherService.getAll()).build();
	}

}

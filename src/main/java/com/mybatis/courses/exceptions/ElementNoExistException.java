package com.mybatis.courses.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class ElementNoExistException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ElementNoExistException(String exception) {
		super(exception);
	}
}

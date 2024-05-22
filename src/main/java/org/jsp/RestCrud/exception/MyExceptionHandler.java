package org.jsp.RestCrud.exception;

import org.jsp.RestCrud.helper.ResponceStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {

	@Autowired
	ResponceStructure structure;

	@ExceptionHandler(DataNotFoundException.class)
	public ResponceStructure handleDataNotFound(DataNotFoundException exception) {
		structure.setData(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Data Not Present");
		return structure;
	}
}

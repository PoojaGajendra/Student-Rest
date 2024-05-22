package org.jsp.RestCrud.helper;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ResponceStructure<T> {

	private String message;
	private int status;
	private T data;

}

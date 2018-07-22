package com.natanlf.cursomc.services.exceptions;

public class ObjectNotFoundException extends RuntimeException { //Tratamento de exceptions

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}

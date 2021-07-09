package com.ifce.agenda.exceptions;

public class EmailExistsException extends Exception {

	public EmailExistsException(String message) {
		super(message);
	}

	private static final long SerialVersionUID = 1L;
}

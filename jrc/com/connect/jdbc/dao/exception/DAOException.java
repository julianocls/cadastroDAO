package com.connect.jdbc.dao.exception;

public class DAOException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DAOException(String msg, Throwable t) {
		super(msg, t);
	}
}

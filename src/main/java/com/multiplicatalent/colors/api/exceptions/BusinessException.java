package com.multiplicatalent.colors.api.exceptions;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Getter;

/**
 * Class <b>BusinessException</b>.
 * 
 * @author Giancarlo
 *
 */
@Getter
public class BusinessException extends Exception implements Serializable {

	private static final long serialVersionUID = -2895214757631534801L;

	private final HttpStatus status;
	private List<ErrorResponse> errors;

	public BusinessException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}

	/**
	 * Method constructor.
	 * 
	 * @param message String
	 * @param status  HttpStatus
	 * @param errors  List of ErrorResponse
	 */
	public BusinessException(String message, HttpStatus status, List<ErrorResponse> errors) {
		super(message);
		this.status = status;
		this.errors = errors;
	}

}

package com.multiplicatalent.colors.api.exceptions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class <b>ExceptionResponse</b>.
 * <p>
 * Class customized for exceptions
 * </p>
 * 
 * @author Giancarlo
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExceptionResponse {

	private Date timestamp;
	private String message;
	private String details;
	private List<ErrorResponse> errors;

	/**
	 * Method constructor.
	 * 
	 * @param timestamp Date
	 * @param message   String
	 * @param details   String
	 */
	public ExceptionResponse(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		this.errors = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "ExceptionResponse [timestamp=" + timestamp + ", message=" + message + ", details=" + details + "]";
	}

}

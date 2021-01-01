package com.multiplicatalent.colors.api.exceptions;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.ToString;

/**
 * Class <b>ExceptionHandlerCustomized</b>.
 * <p>
 * Class Handler for exceptions
 * </p>
 * 
 * @author Giancarlo
 */
@ToString
@ControllerAdvice
@RestController
public class ExceptionHandlerCustomized extends ResponseEntityExceptionHandler {

	/**
	 * Method for intercept exceptions of type BusinessException.
	 * 
	 * @param ex      BusinessException
	 * @param request WebRequest
	 * @return ResponseEntity of ExceptionResponse
	 */
	@ExceptionHandler(BusinessException.class)
	public final ResponseEntity<Object> handleBusinessException(BusinessException ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false), ex.getErrors());

		return new ResponseEntity<>(exceptionResponse, ex.getStatus());
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
				"Bad Request.",
				request.getDescription(false), convertErrors(ex.getBindingResult()));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	private List<ErrorResponse> convertErrors(BindingResult result) {
		List<ErrorResponse> errors = new ArrayList<>();
		if (result.hasErrors()) {
			result.getFieldErrors().forEach(err -> errors
					.add(ErrorResponse.builder()
							.code(err.getField())
							.message(err.getDefaultMessage())
							.build()));
		}
		return errors;
	}

}

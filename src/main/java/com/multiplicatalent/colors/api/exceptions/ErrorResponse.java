package com.multiplicatalent.colors.api.exceptions;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Class <b>ErrorResponse</b>.
 * @author Giancarlo
 *
 */
@Getter
@Setter
@Builder
public class ErrorResponse {
	
	private String code;
	private String message;

}

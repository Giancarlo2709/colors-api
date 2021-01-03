package com.multiplicatalent.colors.api.exceptions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
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

	@Schema(type = "date",
					name = "timestamp",
					description = "Date of Error",
					example = "2021-01-03T13:41:13.637+00:00"
	)
	private Date timestamp;

	@Schema(type = "String",
					name = "message",
					description = "Message of Error",
					example = "Error in business logic"
	)
	private String message;

	@Schema(type = "String",
					name = "details",
					description = "Details of uri",
					example = "uri=/colors"
	)
	private String details;

	@ArraySchema(schema = @Schema(implementation = ErrorResponse.class))
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

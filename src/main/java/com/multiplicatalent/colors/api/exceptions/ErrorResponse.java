package com.multiplicatalent.colors.api.exceptions;

import io.swagger.v3.oas.annotations.media.Schema;
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

	@Schema(type = "String",
					name = "code",
					description = "Code Error",
					example = "name"
	)
	private String code;

	@Schema(type = "String",
					name = "message",
					description = "Message Error",
					example = "El nombre del color ya existe"
	)
	private String message;

}

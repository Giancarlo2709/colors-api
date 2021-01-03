package com.multiplicatalent.colors.api.models.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

/**
 * Class <b>DeleteResponse</b>.
 * @author Giancarlo
 *
 */
@Getter
@Builder
public class DeleteResponse {

	@Schema(type = "boolean",
					name = "deleted",
					description = "Is deleted",
					example = "true"
	)
	private boolean deleted;

}

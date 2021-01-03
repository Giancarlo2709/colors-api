package com.multiplicatalent.colors.api.models.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ColorGetResponse {

	@Schema(type = "Long",
					name = "id",
					description = "Id Color",
					example = "1"
	)
	private Long id;

	@Schema(type = "String",
					name = "name",
					description = "Name of color",
					example = "cerulean"
	)
	private String name;

	@Schema(type = "String",
					name = "color",
					description = "Color Hexadecimal",
					example = "#98B2D1"
	)
	private String color;

}

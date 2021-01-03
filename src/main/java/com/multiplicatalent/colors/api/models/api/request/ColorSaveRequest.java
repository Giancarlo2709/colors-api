package com.multiplicatalent.colors.api.models.api.request;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * Class <b>ColorSaveRequest</b>.
 * @author Giancarlo
 *
 */
@Getter
@Setter
public class ColorSaveRequest {

	@Schema(type = "String",
					name = "name",
					description = "Name of color",
					example = "cerulean"
	)
	@NotEmpty(message = "{message.colors.name.required}")
	private String name;

	@Schema(type = "String",
					name = "year",
					description = "Year of color",
					example = "2000"
	)
	@NotEmpty(message = "{message.colors.year.required}")
	private String year;

	@Schema(type = "String",
					name = "color",
					description = "Color Hexadecimal",
					example = "#98B2D1"
	)
	@NotEmpty(message = "{message.colors.color.required}")
	private String color;

	@Schema(type = "String",
					name = "pantoneValue",
					description = "Pantone Value",
					example = "15-4020"
	)
	@NotEmpty(message = "{message.colors.pantone.value.required}")
	private String pantoneValue;	

}

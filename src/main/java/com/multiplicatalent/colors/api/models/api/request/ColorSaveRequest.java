package com.multiplicatalent.colors.api.models.api.request;

import javax.validation.constraints.NotEmpty;

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
	
	@NotEmpty(message = "{message.colors.name.required}")
	private String name;
	
	@NotEmpty(message = "{message.colors.year.required}")
	private String year;
	
	@NotEmpty(message = "{message.colors.color.required}")
	private String color;
	
	@NotEmpty(message = "{message.colors.pantone.value.required}")
	private String pantoneValue;	

}

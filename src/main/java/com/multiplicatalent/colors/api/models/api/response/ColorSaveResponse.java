package com.multiplicatalent.colors.api.models.api.response;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Class <b>ColorSaveResponse</b>.
 * @author Giancarlo
 */
@Getter
@Setter
@Builder
@XmlRootElement(name = "color")
public class ColorSaveResponse implements Serializable {
	
	private static final long serialVersionUID = 5963797237636052445L;

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
					name = "year",
					description = "Year of color",
					example = "2000"
	)
	private String year;

	@Schema(type = "String",
					name = "color",
					description = "Color Hexadecimal",
					example = "#98B2D1"
	)
	private String color;

	@Schema(type = "String",
					name = "pantone_value",
					description = "Pantone Value",
					example = "15-4020"
	)
	@JsonProperty(value = "pantone_value")
	@XmlElement(name = "pantone_value")
	private String pantoneValue;

}

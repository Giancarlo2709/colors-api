package com.multiplicatalent.colors.api.models.api.response;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@XmlRootElement(name = "color")
public class ColorSaveResponse implements Serializable {
	
	private static final long serialVersionUID = 5963797237636052445L;
	
	private Long id;
	private String name;
	private String year;
	private String color;
	
	@JsonProperty(value = "pantone_value")
	@XmlElement(name = "pantone_value")
	private String pantoneValue;

}

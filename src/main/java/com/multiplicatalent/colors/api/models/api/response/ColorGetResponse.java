package com.multiplicatalent.colors.api.models.api.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ColorGetResponse {
	
	private Long id;
	private String name;
	private String color;

}

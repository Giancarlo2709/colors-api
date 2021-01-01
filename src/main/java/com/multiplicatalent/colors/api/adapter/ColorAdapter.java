package com.multiplicatalent.colors.api.adapter;

import com.multiplicatalent.colors.api.models.api.request.ColorSaveRequest;
import com.multiplicatalent.colors.api.models.api.response.ColorGetResponse;
import com.multiplicatalent.colors.api.models.api.response.ColorSaveResponse;
import com.multiplicatalent.colors.api.models.entity.Color;
import com.multiplicatalent.colors.api.models.enums.StatusType;

/**
 * Class <b>ColorAdapter</b>.
 * @author Giancarlo
 *
 */
public class ColorAdapter {
	
	public ColorAdapter() {
		super();
	}
	
	public static ColorGetResponse convertColorToColorGetResponse(Color color) {
		return ColorGetResponse.builder()
				.id(color.getId())
				.name(color.getName())
				.color(color.getColor())
				.build();
	}
	
	public static Color convertColorSaveRequestToColor(ColorSaveRequest colorSaveRequest) {
		return Color.builder()
				.name(colorSaveRequest.getName())
				.year(colorSaveRequest.getYear())
				.color(colorSaveRequest.getColor())
				.pantoneValue(colorSaveRequest.getPantoneValue())
				.status(StatusType.ACTIVE.getCode())
				.build();
	}
	
	public static ColorSaveResponse convertColorToColorSaveResponse(Color color) {
		return ColorSaveResponse.builder()
				.id(color.getId())
				.name(color.getName())
				.year(color.getYear())
				.color(color.getColor())
				.pantoneValue(color.getPantoneValue())
				.build();
	}
	
	public static Color updateColor(ColorSaveRequest colorSaveRequest, Color color) {
		color.setName(colorSaveRequest.getName());
		color.setYear(colorSaveRequest.getYear());
		color.setColor(colorSaveRequest.getColor());
		color.setPantoneValue(colorSaveRequest.getPantoneValue());
		return color;
	}

}

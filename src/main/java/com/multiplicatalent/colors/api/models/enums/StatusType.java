package com.multiplicatalent.colors.api.models.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;

/**
 * Enum <b>StatusType</b>.
 * @author Giancarlo
 *
 */
@AllArgsConstructor
public enum StatusType {

	ACTIVE(Integer.valueOf(1), "ACTIVO"),

	INACTIVE(Integer.valueOf(0), "INACTIVO");

	private static final List<StatusType> list = new ArrayList<>();

	private static final Map<Integer, StatusType> lookup = new HashMap<>();

	private Integer code;

	private String value;

	static {
		for (StatusType c : StatusType.values()) {
			lookup.put(c.getCode(), c);
			list.add(c);
		}
	}

	public Integer getCode() {
		return code;
	}

	public String getValue() {
		return value;
	}

	public static List<StatusType> getList() {
		return list;
	}

	public static StatusType getUserStatusType(Integer code) {
		return lookup.get(code);
	}

}

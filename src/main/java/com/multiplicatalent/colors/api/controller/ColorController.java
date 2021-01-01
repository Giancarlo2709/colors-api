package com.multiplicatalent.colors.api.controller;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multiplicatalent.colors.api.business.ColorService;
import com.multiplicatalent.colors.api.exceptions.BusinessException;
import com.multiplicatalent.colors.api.models.api.request.ColorSaveRequest;
import com.multiplicatalent.colors.api.models.api.response.ColorGetResponse;
import com.multiplicatalent.colors.api.models.api.response.ColorSaveResponse;
import com.multiplicatalent.colors.api.models.api.response.DeleteResponse;

import lombok.ToString;

/**
 * Class <b>ColorController</b>.
 * <p>
 * Class for endpoints of colors
 * </p>
 * 
 * @author Giancarlo
 */
@ToString
@RestController
@RequestMapping("/colors")
public class ColorController {
	
	private final ColorService colorService;
	
	public ColorController(ColorService colorService) {
		this.colorService = colorService;
	}

	@GetMapping(value = "", produces = { 
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public Page<ColorGetResponse> findAllPageable(Pageable pageable) {
		return this.colorService.findAllPageable(pageable);
	}
	
	@GetMapping(value = "/{id}", produces = { 
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ColorGetResponse findById(@PathVariable Long id) throws BusinessException {
		return this.colorService.findById(id);
	}
	
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ColorSaveResponse createColor(@Valid @RequestBody ColorSaveRequest colorSaveRequest) 
			throws BusinessException {
		return this.colorService.createColor(colorSaveRequest);
	}
	
	@PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ColorSaveResponse updateColor(@PathVariable Long id,
			@Valid @RequestBody ColorSaveRequest colorSaveRequest) throws BusinessException {
		return this.colorService.updateColor(id, colorSaveRequest);
	}
	
	@DeleteMapping(value = "/{id}", produces = { 
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public DeleteResponse deleteColor(@PathVariable Long id) throws BusinessException {
		return this.colorService.deleteColor(id);
	}

}

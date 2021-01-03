package com.multiplicatalent.colors.api.controller;

import javax.validation.Valid;

import com.multiplicatalent.colors.api.exceptions.ExceptionResponse;
import com.multiplicatalent.colors.api.models.api.request.PageRequest;
import com.multiplicatalent.colors.api.models.api.response.ColorGetIdResponse;
import com.multiplicatalent.colors.api.models.api.response.PageResponse;
import com.multiplicatalent.colors.api.util.PageUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.multiplicatalent.colors.api.business.ColorService;
import com.multiplicatalent.colors.api.exceptions.BusinessException;
import com.multiplicatalent.colors.api.models.api.request.ColorSaveRequest;
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
@Tag(name = "color", description = "the Color API")
public class ColorController {
	
	private final ColorService colorService;
	
	public ColorController(ColorService colorService) {
		this.colorService = colorService;
	}

	@GetMapping(value = "", produces = { 
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseStatus(HttpStatus.OK)
	@Operation(summary = "Get all colors pageable", method = "GET", tags = {"color"})
	@ApiResponses({
					@ApiResponse(responseCode = "200", description = "",
									content = @Content(schema = @Schema(implementation = PageResponse.class))),
	})
	public PageResponse findAllPageable(PageRequest pageable) {
		return this.colorService.findAllPageable(PageUtil.getPageable(pageable));
	}
	
	@GetMapping(value = "/{id}", produces = { 
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseStatus(HttpStatus.OK)
	@Operation(summary = "Get colors by Id", method = "GET", tags = {"color"})
	@ApiResponses({
					@ApiResponse(responseCode = "200", description = "",
									content = @Content(schema = @Schema(implementation = ColorGetIdResponse.class))),
					@ApiResponse(responseCode = "500", description = "Color with id 16 not found",
					content = @Content(schema =  @Schema(implementation = ExceptionResponse.class)))
	})
	public ColorGetIdResponse findById(@PathVariable Long id) throws BusinessException {
		return this.colorService.findById(id);
	}
	
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary = "Create color", method = "POST", tags = {"color"})
	@ApiResponses({
					@ApiResponse(responseCode = "201", description = "",
									content = @Content(schema = @Schema(implementation = ColorSaveResponse.class))),
					@ApiResponse(responseCode = "400", description = "Bad Request.",
									content = @Content(schema =  @Schema(implementation = ExceptionResponse.class))),
					@ApiResponse(responseCode = "500", description = "Error in business logic",
									content = @Content(schema =  @Schema(implementation = ExceptionResponse.class)))
	})
	public ColorSaveResponse createColor(@Valid @RequestBody ColorSaveRequest colorSaveRequest) 
			throws BusinessException {
		return this.colorService.createColor(colorSaveRequest);
	}
	
	@PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseStatus(HttpStatus.OK)
	@Operation(summary = "Update color", method = "PUT", tags = {"color"})
	@ApiResponses({
					@ApiResponse(responseCode = "200", description = "",
									content = @Content(schema = @Schema(implementation = ColorSaveResponse.class))),
					@ApiResponse(responseCode = "400", description = "Bad Request.",
									content = @Content(schema =  @Schema(implementation = ExceptionResponse.class))),
					@ApiResponse(responseCode = "500", description = "Error in business logic",
									content = @Content(schema =  @Schema(implementation = ExceptionResponse.class)))
	})
	public ColorSaveResponse updateColor(@PathVariable Long id,
			@Valid @RequestBody ColorSaveRequest colorSaveRequest) throws BusinessException {
		return this.colorService.updateColor(id, colorSaveRequest);
	}
	
	@DeleteMapping(value = "/{id}", produces = { 
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseStatus(HttpStatus.OK)
	@Operation(summary = "Delete color", method = "DELETE", tags = {"color"})
	@ApiResponses({
					@ApiResponse(responseCode = "200", description = "",
									content = @Content(schema = @Schema(implementation = DeleteResponse.class))),
					@ApiResponse(responseCode = "500", description = "Error in business logic",
									content = @Content(schema =  @Schema(implementation = ExceptionResponse.class)))
	})
	public DeleteResponse deleteColor(@PathVariable Long id) throws BusinessException {
		return this.colorService.deleteColor(id);
	}

}

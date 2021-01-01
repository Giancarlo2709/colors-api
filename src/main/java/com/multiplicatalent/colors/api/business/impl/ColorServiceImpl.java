package com.multiplicatalent.colors.api.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.multiplicatalent.colors.api.adapter.ColorAdapter;
import com.multiplicatalent.colors.api.business.ColorService;
import com.multiplicatalent.colors.api.exceptions.BusinessException;
import com.multiplicatalent.colors.api.exceptions.ErrorResponse;
import com.multiplicatalent.colors.api.models.api.request.ColorSaveRequest;
import com.multiplicatalent.colors.api.models.api.response.ColorGetResponse;
import com.multiplicatalent.colors.api.models.api.response.ColorSaveResponse;
import com.multiplicatalent.colors.api.models.api.response.DeleteResponse;
import com.multiplicatalent.colors.api.models.entity.Color;
import com.multiplicatalent.colors.api.models.enums.StatusType;
import com.multiplicatalent.colors.api.models.repository.ColorRepository;

import lombok.ToString;

/**
 * Class <b>ColorServiceImpl</b>.
 * 
 * @author Giancarlo
 *
 */
@ToString
@Service
public class ColorServiceImpl implements ColorService {

	private static final HttpStatus INTERNAL_SERVER_ERROR = HttpStatus.INTERNAL_SERVER_ERROR;
	private static final String MESSAGE_COLOR_NOT_FOUND = "Color with id %s not found";

	private final ColorRepository colorRepository;

	public ColorServiceImpl(ColorRepository colorRepository) {
		this.colorRepository = colorRepository;
	}

	@Override
	public ColorSaveResponse createColor(ColorSaveRequest colorSaveRequest) throws BusinessException {
		saveColorValidation(colorSaveRequest, null);
		return ColorAdapter.convertColorToColorSaveResponse(
				this.colorRepository.save(ColorAdapter.convertColorSaveRequestToColor(colorSaveRequest)));
	}

	@Override
	public ColorSaveResponse updateColor(Long id, ColorSaveRequest colorSaveRequest) throws BusinessException {
		saveColorValidation(colorSaveRequest, id);

		Color color = this.colorRepository.findByIdAndStatus(id, StatusType.ACTIVE.getCode()).orElseThrow(
				() -> new BusinessException(String.format(MESSAGE_COLOR_NOT_FOUND, id), INTERNAL_SERVER_ERROR));

		ColorAdapter.updateColor(colorSaveRequest, color);

		return ColorAdapter.convertColorToColorSaveResponse(this.colorRepository.save(color));
	}

	private void saveColorValidation(ColorSaveRequest colorSaveRequest, Long id) throws BusinessException {
		Optional<Color> colorOptional;

		if (Objects.nonNull(id) && id > 0) {
			colorOptional = this.colorRepository.findByColorAndStatusAndIdNot(colorSaveRequest.getName(),
					StatusType.ACTIVE.getCode(), id);
		} else {
			colorOptional = this.colorRepository.findByNameAndStatus(colorSaveRequest.getName(),
					StatusType.ACTIVE.getCode());
		}

		if (colorOptional.isPresent()) {
			List<ErrorResponse> errors = new ArrayList<>();

			errors.add(ErrorResponse.builder().code("name").message("El nombre del color ya existe").build());

			throw new BusinessException("Error en la logica de negocio", INTERNAL_SERVER_ERROR, errors);
		}
	}

	@Override
	public Page<ColorGetResponse> findAllPageable(Pageable pageable) {
		Page<Color> pageColors = this.colorRepository.findByStatus(StatusType.ACTIVE.getCode(), pageable);
		return pageColors.map(ColorAdapter::convertColorToColorGetResponse);
	}

	@Override
	public ColorGetResponse findById(Long id) throws BusinessException {
		Color color = this.colorRepository.findByIdAndStatus(id, StatusType.ACTIVE.getCode()).orElseThrow(
				() -> new BusinessException(String.format(MESSAGE_COLOR_NOT_FOUND, id), INTERNAL_SERVER_ERROR));

		return ColorAdapter.convertColorToColorGetResponse(color);
	}

	@Override
	public DeleteResponse deleteColor(Long id) throws BusinessException {
		Color color = this.colorRepository.findByIdAndStatus(id, StatusType.ACTIVE.getCode()).orElseThrow(
				() -> new BusinessException(String.format(MESSAGE_COLOR_NOT_FOUND, id), INTERNAL_SERVER_ERROR));

		color.setStatus(StatusType.INACTIVE.getCode());
		this.colorRepository.save(color);

		return DeleteResponse.builder().deleted(true).build();
	}

}

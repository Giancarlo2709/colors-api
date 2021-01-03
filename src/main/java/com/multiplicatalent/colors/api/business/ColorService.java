package com.multiplicatalent.colors.api.business;

import com.multiplicatalent.colors.api.exceptions.BusinessException;
import com.multiplicatalent.colors.api.models.api.request.ColorSaveRequest;
import com.multiplicatalent.colors.api.models.api.response.ColorGetIdResponse;
import com.multiplicatalent.colors.api.models.api.response.ColorGetResponse;
import com.multiplicatalent.colors.api.models.api.response.ColorSaveResponse;
import com.multiplicatalent.colors.api.models.api.response.DeleteResponse;

import com.multiplicatalent.colors.api.models.api.response.PageResponse;
import org.springframework.data.domain.Pageable;

/**
 * Interface <b>ColorService</b>.
 * @author Giancarlo
 *
 */
public interface ColorService {
	
	ColorSaveResponse createColor(ColorSaveRequest colorSaveRequest) throws BusinessException;
	
	ColorSaveResponse updateColor(Long id, ColorSaveRequest colorSaveRequest) 
			throws BusinessException;

	PageResponse findAllPageable(Pageable pageable);

	ColorGetIdResponse findById(Long id) throws BusinessException;
	
	DeleteResponse deleteColor(Long id) throws BusinessException;
}

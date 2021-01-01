package com.multiplicatalent.colors.api.business;

import com.multiplicatalent.colors.api.exceptions.BusinessException;
import com.multiplicatalent.colors.api.models.api.request.ColorSaveRequest;
import com.multiplicatalent.colors.api.models.api.response.ColorGetResponse;
import com.multiplicatalent.colors.api.models.api.response.ColorSaveResponse;
import com.multiplicatalent.colors.api.models.api.response.DeleteResponse;

import org.springframework.data.domain.Page;
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
	
	Page<ColorGetResponse> findAllPageable(Pageable pageable);
	
	ColorGetResponse findById(Long id) throws BusinessException;
	
	DeleteResponse deleteColor(Long id) throws BusinessException;
}

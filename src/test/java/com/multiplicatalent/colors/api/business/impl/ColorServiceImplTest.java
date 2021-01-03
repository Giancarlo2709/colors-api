package com.multiplicatalent.colors.api.business.impl;

import com.multiplicatalent.colors.api.exceptions.BusinessException;
import com.multiplicatalent.colors.api.models.api.request.ColorSaveRequest;
import com.multiplicatalent.colors.api.models.api.response.ColorGetIdResponse;
import com.multiplicatalent.colors.api.models.api.response.ColorSaveResponse;
import com.multiplicatalent.colors.api.models.api.response.DeleteResponse;
import com.multiplicatalent.colors.api.models.api.response.PageResponse;
import com.multiplicatalent.colors.api.models.entity.Color;
import com.multiplicatalent.colors.api.models.repository.ColorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Class <b>ColorServiceImplTest</b>.
 * Test All methods from ColorServiceImpl.
 * @author Giancarlo
 */
@ExtendWith(MockitoExtension.class)
class ColorServiceImplTest {

  @Mock
  ColorRepository colorRepository;

  @InjectMocks
  ColorServiceImpl service;

  Color returnColor;

  ColorSaveRequest colorSaveRequest;

  @BeforeEach
  void setUp() {
    returnColor = Color.builder().id(1L).name("cerulean").build();
    colorSaveRequest = new ColorSaveRequest();
    colorSaveRequest.setName("cerulean");
    colorSaveRequest.setYear("2000");
    colorSaveRequest.setColor("#98B2D1");
    colorSaveRequest.setPantoneValue("15-4020");
  }

  @Test
  void createColor() throws BusinessException {
    when(colorRepository.save(any())).thenReturn(returnColor);
    when(colorRepository.findByNameAndStatus(any(), any())).thenReturn(Optional.empty());

    ColorSaveResponse colorSaveResponse = service.createColor(colorSaveRequest);

    assertNotNull(colorSaveResponse);
    assertEquals(1L, colorSaveResponse.getId());

    verify(colorRepository).save(any());
    verify(colorRepository).findByNameAndStatus(any(), any());
  }

  @Test
  void createColorWhenNameExists() {
    when(colorRepository.findByNameAndStatus(any(), any()))
            .thenReturn(Optional.of(returnColor));

    assertThrows(BusinessException.class, () -> service.createColor(colorSaveRequest));
  }

  @Test
  void updateColor() throws BusinessException {
    when(colorRepository.save(any())).thenReturn(returnColor);
    when(colorRepository.findByColorAndStatusAndIdNot(any(), any(), any()))
            .thenReturn(Optional.empty());

    when(colorRepository.findByIdAndStatus(any(), any())).thenReturn(Optional.of(returnColor));

    ColorSaveResponse colorSaveResponse = service.updateColor(1L, colorSaveRequest);

    assertNotNull(colorSaveResponse);
    assertEquals(1L, colorSaveResponse.getId());

    verify(colorRepository).save(any());
    verify(colorRepository).findByColorAndStatusAndIdNot(any(), any(), any());
  }

  @Test
  void updateColorWhenNotFound() {
    when(colorRepository.findByIdAndStatus(any(), any()))
            .thenReturn(Optional.ofNullable(null));

    assertThrows(BusinessException.class, () -> service.updateColor(1L, colorSaveRequest));
  }

  @Test
  void findAllPageable() {
    int pageNumber = 0;
    int pageSize = 1;
    Pageable pageable = PageRequest.of(pageNumber, pageSize);
    Page<Color> page = new PageImpl<>(Collections.singletonList(returnColor));

    when(colorRepository.findByStatus(any(), any())).thenReturn(page);

    PageResponse pageResponse = service.findAllPageable(pageable);
    assertEquals(pageResponse.getColors().size(), 1);

    verify(colorRepository).findByStatus(any(), any());
  }

  @Test
  void findById() throws BusinessException {

    when(colorRepository.findByIdAndStatus(any(), any()))
            .thenReturn(Optional.of(returnColor));

    ColorGetIdResponse colorGetIdResponse = service.findById(1L);

    assertEquals(1L, colorGetIdResponse.getId());

    verify(colorRepository).findByIdAndStatus(any(), any());
  }

  @Test
  void findByIdWhenNotFound() {
    when(colorRepository.findByIdAndStatus(any(), any()))
            .thenReturn(Optional.ofNullable(null));

    assertThrows(BusinessException.class, () -> service.findById(1L));
  }

  @Test
  void deleteColor() throws BusinessException {
    when(colorRepository.findByIdAndStatus(any(), any()))
            .thenReturn(Optional.of(returnColor));

    DeleteResponse deleteResponse = service.deleteColor(1L);

    assertTrue(deleteResponse.isDeleted());

    verify(colorRepository).findByIdAndStatus(any(), any());
  }

  @Test
  void deleteColorWhenNotFound() {
    when(colorRepository.findByIdAndStatus(any(), any()))
            .thenReturn(Optional.ofNullable(null));

    assertThrows(BusinessException.class, () -> service.deleteColor(1L));
  }

  @Test
  public final void testToString() {
    assertFalse(service.toString().contains("@"));
  }
}
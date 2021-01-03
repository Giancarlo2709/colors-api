package com.multiplicatalent.colors.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.multiplicatalent.colors.api.business.ColorService;
import com.multiplicatalent.colors.api.models.api.request.ColorSaveRequest;
import com.multiplicatalent.colors.api.models.api.response.ColorGetIdResponse;
import com.multiplicatalent.colors.api.models.api.response.ColorSaveResponse;
import com.multiplicatalent.colors.api.models.api.response.DeleteResponse;
import com.multiplicatalent.colors.api.models.api.response.PageResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class ColorControllerTest {

  @Mock
  ColorService colorService;

  MockMvc mockMvc;

  @InjectMocks
  ColorController colorController;

  ColorGetIdResponse colorGetIdResponse;

  PageResponse pageResponse;

  ColorSaveRequest colorSaveRequest;

  ColorSaveResponse colorSaveResponse;

  @BeforeEach
  void setUp() {

    colorGetIdResponse = ColorGetIdResponse.builder()
            .id(1L)
            .build();

    pageResponse = PageResponse.builder()
            .colors(new ArrayList<>())
            .build();

    colorSaveRequest = new ColorSaveRequest();
    colorSaveRequest.setName("cerulean");
    colorSaveRequest.setYear("2000");
    colorSaveRequest.setColor("#98B2D1");
    colorSaveRequest.setPantoneValue("15-4020");

    colorSaveResponse = ColorSaveResponse.builder().id(1L).build();

    mockMvc = MockMvcBuilders
            .standaloneSetup(colorController)
            .build();
  }

  @Test
  void findAllPageable() throws Exception {
    when(colorService.findAllPageable(any())).thenReturn(pageResponse);

    mockMvc.perform(get("/colors?page=1&size=5"))
            .andExpect(status().isOk());
  }

  @Test
  void findById() throws Exception {
    when(colorService.findById(anyLong())).thenReturn(colorGetIdResponse);

    mockMvc.perform(get("/colors/1"))
            .andExpect(status().isOk());
  }

  @Test
  void createColor() throws Exception {
    when(colorService.createColor(any())).thenReturn(colorSaveResponse);
    mockMvc.perform(post("/colors")
            .contentType(MediaType.APPLICATION_JSON_VALUE).content(mapToJson(colorSaveRequest)))
            .andExpect(status().isCreated());
  }

  @Test
  void updateColor() throws Exception {
    when(colorService.updateColor(anyLong(), any())).thenReturn(colorSaveResponse);

    mockMvc.perform(put("/colors/1")
            .contentType(MediaType.APPLICATION_JSON_VALUE).content(mapToJson(colorSaveRequest)))
            .andExpect(status().isOk());
  }

  @Test
  void deleteColor() throws Exception {
    when(colorService.deleteColor(anyLong())).thenReturn(DeleteResponse.builder().build());

    mockMvc.perform(delete("/colors/1"))
            .andExpect(status().isOk());
  }

  @Test
  void testToString() {
    assertFalse(colorController.toString().contains("@"));
  }

  private String mapToJson(Object obj) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.writeValueAsString(obj);
  }
}
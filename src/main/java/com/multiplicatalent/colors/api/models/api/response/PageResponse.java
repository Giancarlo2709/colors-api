package com.multiplicatalent.colors.api.models.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Class <b>PageResponse</b>.
 * @author Giancarlo
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageResponse {

  private Long totalElements;
  private Integer totalPages;
  private Boolean first;
  private Boolean last;
  private List<ColorGetResponse> colors;
}

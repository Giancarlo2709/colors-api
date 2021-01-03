package com.multiplicatalent.colors.api.models.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * Class <b>PageRequest</b>.
 * @author Giancarlo
 */
@Getter
@Setter
public class PageRequest {

  @Schema(type = "Integer",
          name = "page",
          description = "Page current",
          example = "1"
  )
  private Integer page;

  @Schema(type = "Integer",
          name = "size",
          description = "Size by page",
          example = "10"
  )
  private Integer size;
}

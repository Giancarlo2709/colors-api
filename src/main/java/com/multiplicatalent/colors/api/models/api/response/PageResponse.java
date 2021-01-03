package com.multiplicatalent.colors.api.models.api.response;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
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

  @Schema(type = "Long",
          name = "totalElements",
          description = "Total of elements",
          example = "150"
  )
  private Long totalElements;

  @Schema(type = "Integer",
          name = "totalPages",
          description = "Total of pages",
          example = "3"
  )
  private Integer totalPages;

  @Schema(type = "boolean",
          name = "first",
          description = "Is first page",
          example = "true"
  )
  private Boolean first;

  @Schema(type = "boolean",
          name = "last",
          description = "Is Last page",
          example = "false"
  )
  private Boolean last;

  @ArraySchema(schema = @Schema(title= "List of colors",
          implementation = ColorGetResponse.class))
  private List<ColorGetResponse> colors;
}

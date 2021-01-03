package com.multiplicatalent.colors.api.models.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageRequest {

  private Integer page;
  private Integer size;
}

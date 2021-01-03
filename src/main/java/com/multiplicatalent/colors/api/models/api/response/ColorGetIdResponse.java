package com.multiplicatalent.colors.api.models.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@Getter
@Setter
@Builder
@JsonTypeName(value = "color")
@XmlRootElement(name = "color")
public class ColorGetIdResponse implements Serializable {

  private Long id;
  private String name;
  private String color;
  private String year;

  @JsonProperty(value = "pantone_value")
  @XmlElement(name = "pantone_value")
  private String pantoneValue;
}

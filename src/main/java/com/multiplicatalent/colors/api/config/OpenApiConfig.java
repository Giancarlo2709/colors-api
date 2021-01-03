package com.multiplicatalent.colors.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class <b>OpenApiConfig</b>.
 * @author Giancarlo
 */
@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
    return new OpenAPI().info(new Info()
            .title("Color API")
            .version(appVersion)
            .description("Color Api created using springdocs - " +
                    "a library for OpenAPI 3 with spring boot.")
            .contact(getContact())
            .termsOfService("http://swagger.io/terms/")
            .license(new License().name("Apache 2.0")
                    .url("http://springdoc.org")));
  }

  public Contact getContact() {
    Contact contact = new Contact();
    contact.setName("Giancarlo Elvis Yarleque Juarez");
    contact.setEmail("giancarlo2709@gmail.com");
    contact.setUrl("https://github.com/Giancarlo2709");
    return contact;
  }
}

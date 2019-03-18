package com.mantovanello.poc.frezze;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Mantovanello
 *
 *         Spring Boot main application
 */
@SpringBootApplication
@EnableSwagger2
public class FrezzeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrezzeApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	/**
	 * Set base controller package to be scanned by Swagger2 API
	 */
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.mantovanello.poc.frezze.controller")).build()
				.apiInfo(apiInfo());
	}

	/**
	 * Define a few informations about the developed API to be displayed in
	 * Swagger's UI
	 */
	private ApiInfo apiInfo() {
		return new ApiInfo("Frezze's REST API POC",
				"API responsible to fetch some track recommendations data from Spotify API and retrieve it in a simpler form as a resource.",
				"1.0", "Terms Of Service",
				new Contact("Felipe Mantovanello", "https://github.com/mantovanello", "felipe.mantovanello@gmail.com"),
				"License", "", Collections.emptyList());
	}

}

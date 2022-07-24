package mx.com.udes.metaphorce;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("mx.com.udes.metaphorce.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo());
    }
	
	private ApiInfo getApiInfo() {
		return new ApiInfo(
				"Metaphorce",
				"Servicio web para prueba de Metaphorce",
				"1.0", 
				"",
				new Contact(
						"Wyatt García", 
						"https://www.facebook.com/wyattrafael.manuelgarcia/",
						"wyattrafael1998@gmail.com"),
				"LICENSE",
				"LICENSE URL",
				Collections.emptyList());
	}
}

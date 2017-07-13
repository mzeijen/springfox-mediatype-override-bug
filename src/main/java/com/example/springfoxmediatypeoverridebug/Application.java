package com.example.springfoxmediatypeoverridebug;

import com.google.common.collect.Sets;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * With this docket we set the consumes and produces by default on the docket. I expect that this will only define  global consumes and produces media-types
	 * in the Swagger spec. However not only that happens but these global consumes and produces are also merged with the resource specific
	 * consumes and produces media-types. That means that it is impossible to fully override these global consumes and produces. You can only add to it.
	 */
	@Bean
	public Docket docketLevelConsumesProducesApi() {
		return new Docket(DocumentationType.SWAGGER_2)
			.groupName("1-docket-level")
			.select()
			.apis(RequestHandlerSelectors.any())
			.paths(PathSelectors.regex("/docket-level/.*")).build()
			.pathMapping("/")
			.useDefaultResponseMessages(false)
			.consumes(Sets.newHashSet("application/json", "application/xml"))
			.produces(Sets.newHashSet("application/json", "application/xml"));
	}

	/**
	 * With this docket we set the consumes and produces on the controller level via the @RequestMapping and override it per resource method. In this
	 * case the Swagger specification is generated as expected.
	 * This is a workaround, but not one we would like to use. It forces us to define these media-types on all classes or use annotation inheritance tricks in Spring.
	 */
	@Bean
	public Docket controllerLevelConsumesProducesApi() {
		return new Docket(DocumentationType.SWAGGER_2)
			.groupName("2-controller-level")
			.select()
			.apis(RequestHandlerSelectors.any())
			.paths(PathSelectors.regex("/controller-level/.*")).build()
			.pathMapping("/")
			.useDefaultResponseMessages(false);
	}

}

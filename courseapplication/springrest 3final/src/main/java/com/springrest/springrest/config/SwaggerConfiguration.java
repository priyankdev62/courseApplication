package com.springrest.springrest.config;

import com.springrest.springrest.controller.MyController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    Logger logger = LoggerFactory.getLogger(SwaggerConfiguration.class);



    @Bean
    public Docket api() {
        logger.error("swagger is sick now");
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.springrest.springrest"))
                .paths(PathSelectors.any()).build().apiInfo(apiInfo());
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("REST API Document").description("description for api")
                .version("1.0").build();
    }

}
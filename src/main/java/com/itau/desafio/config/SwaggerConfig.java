package com.itau.desafio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket transactionApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.itau.desafio"))
                .paths(PathSelectors.any())
                .build().apiInfo(metaInfo());
    }


    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Itaú Unibanco - Desafio de Programação",
                "Desafio de Programação para vaga de desenvolvedor Java Jr.",
                "1.0",
                "Terms of Service",
                new Contact("Rogério Ferreira da Silva",
                        "https://www.linkedin.com/in/rfsilvapcd/",
                        "rogeriofatecitu@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/license.html", new ArrayList<VendorExtension>()
        );
        return apiInfo;
    }
}

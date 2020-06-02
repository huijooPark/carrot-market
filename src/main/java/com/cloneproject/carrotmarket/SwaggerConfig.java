package com.cloneproject.carrotmarket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    private String version;
    private String title;

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description("carrot-market user/sales API Docs.")
                .build();
    }


    @Bean
    public Docket commonApi() {

        version = "V0.1";
        title = "Carrot-market-API" + version;

        List<ResponseMessage> responseMessages = new ArrayList<>();
        responseMessages.add(new ResponseMessageBuilder()
                .code(200)
                .message("|| OK ||")
                .build());
        responseMessages.add(new ResponseMessageBuilder()
                .code(404)
                .message("|| Not Found ||")
                .build());
        responseMessages.add(new ResponseMessageBuilder()
                .code(500)
                .message("|| Internal Server Error ||")
                .build());

        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .groupName(version)
                .apiInfo(this.apiInfo())
                .select()
                .apis(RequestHandlerSelectors
                    .basePackage("com.cloneproject.carrotmarket.controller"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .globalResponseMessage(RequestMethod.GET, responseMessages);
    }

}

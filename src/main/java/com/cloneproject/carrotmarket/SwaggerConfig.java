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
    private String description;
    @Bean
    public Docket commonApi() {

        version = "v0.1";
        title = "Carrot-market-API" + version;
        description = "Carrot-market 회원가입/중고거래 API Docs.";

        // error response 공통 설정
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
                .apis(RequestHandlerSelectors.basePackage("com.cloneproject.carrotmarket.controller")) // 지정된 패키지만 API 문서화
                //.apis(RequestHandlerSelectors.any()) // 전체 문서의 API 화
                .paths(PathSelectors.ant("/api/**")) // 특정경로에 있는 컨트롤러만 포함
                //.paths(PathSelectors.any()) // 모든 URL 패턴에 대해 문서화 수행
                .build()
                .globalResponseMessage(RequestMethod.GET, responseMessages);
    }

    // 문서 커스텀 하기..
    private ApiInfo apiInfo() {

        String version_name = "Simple Docs." + version;

        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .version(version_name)
                .build();
    }

}

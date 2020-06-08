package com.cloneproject.carrotmarket;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/*
* ################# WAR 파일 생성을 위해 (Tomcat을 사용) 필요한 class #####################
* */

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CarrotMarketApplication.class);
	}

}

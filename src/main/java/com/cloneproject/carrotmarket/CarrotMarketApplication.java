package com.cloneproject.carrotmarket;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/*
* ######### Spring Boot App 시작 하는 Class ######################
* */

@SpringBootApplication
// @SpringBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan
@PropertySource(value = {"classpath:${mailserver.config}"})
public class CarrotMarketApplication {

	public static void main(String[] args) {

		SpringApplication.run(CarrotMarketApplication.class, args);
		String strClassPath = System.getProperty("java.class.path");
		//System.out.println("strClassPath: "+strClassPath);
		System.out.println("################################################################################");
		System.out.println("################################################################################");
		System.out.println("################# Carrot Market RESTful API SERVER Started !! ##################");
		System.out.println("################################################################################");
		System.out.println("################################################################################");

	}

}

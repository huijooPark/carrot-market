package com.cloneproject.carrotmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @SpringBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan
public class CarrotMarketApplication {

	public static void main(String[] args) {

		SpringApplication.run(CarrotMarketApplication.class, "--debug");
		System.out.println("################################################################################");
		System.out.println("################################################################################");
		System.out.println("################# Carrot Market RESTful API SERVER Started !! ##################");
		System.out.println("################################################################################");
		System.out.println("################################################################################");

	}

}

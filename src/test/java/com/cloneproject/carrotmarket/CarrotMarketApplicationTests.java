package com.cloneproject.carrotmarket;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CarrotMarketApplicationTests {

	@Value("${email.corpName}")
	private String corpName;

	@Test
	void contextLoads() {
		System.out.println("#################################");
		System.out.println(corpName);
		System.out.println("#################################");

	}

}

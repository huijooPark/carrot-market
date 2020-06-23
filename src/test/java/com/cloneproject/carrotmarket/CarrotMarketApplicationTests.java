package com.cloneproject.carrotmarket;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@TestPropertySource("classpath:/application_test.properties")
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

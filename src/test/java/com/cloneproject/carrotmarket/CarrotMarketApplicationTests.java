package com.cloneproject.carrotmarket;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class CarrotMarketApplicationTests {

	@Autowired
	Environment environment;

	@Test
	void contextLoads() {
		System.out.println("test : " + environment.getProperty("test.application"));
	}

}

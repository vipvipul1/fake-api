package com.scaler.demo.fakeapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FakeApiApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(FakeApiApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FakeApiApplication.class, args);
//		String[] beanNames = context.getBeanDefinitionNames();
//		for (String bean: beanNames)
//            LOGGER.info("Bean: {}", bean);
	}

}

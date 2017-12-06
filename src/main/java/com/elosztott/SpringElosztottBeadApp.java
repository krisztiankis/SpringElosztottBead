package com.elosztott;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.servlet.*;

@SpringBootApplication
public class SpringElosztottBeadApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"/META-INF/spring/integration-config.xml");

		SpringApplication.run(SpringElosztottBeadApp.class, args);
	}
}

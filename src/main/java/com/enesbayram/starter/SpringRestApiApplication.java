package com.enesbayram.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.enesbayram") //com.enesbayram paketi içini tara diyoruz. beanı oluştur diyoruz
@SpringBootApplication
public class SpringRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestApiApplication.class, args);
	}

}

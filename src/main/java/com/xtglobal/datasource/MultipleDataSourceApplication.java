package com.xtglobal.datasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="{com.xtglobal.datasource.*}")
public class MultipleDataSourceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MultipleDataSourceApplication.class, args);
	}

}

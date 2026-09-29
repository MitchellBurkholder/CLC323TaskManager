package com.cst323.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({ "com.cst323.demo"})
@SpringBootApplication
class DemoApplicationTests {

	public static void main(String[] args)  {
		SpringApplication.run(DemoApplicationTests.class, args);
	}

}

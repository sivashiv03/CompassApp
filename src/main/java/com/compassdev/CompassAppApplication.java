package com.compassdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.compassdev.*"})
public class CompassAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompassAppApplication.class, args);
	}

}

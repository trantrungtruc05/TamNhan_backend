package com.tamnhan.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.tamnhan"})
@EntityScan("com.tamnhan")
@EnableJpaRepositories("com.tamnhan")
public class TamNhanBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TamNhanBackendApplication.class, args);
	}

}


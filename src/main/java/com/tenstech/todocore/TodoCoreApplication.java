package com.tenstech.todocore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TodoCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoCoreApplication.class, args);
	}

}

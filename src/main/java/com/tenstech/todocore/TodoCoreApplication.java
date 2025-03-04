package com.tenstech.todocore;

import com.tenstech.todocore.config.RsaKeyConfigProperties;
import com.tenstech.todocore.model.User;
import com.tenstech.todocore.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties(RsaKeyConfigProperties.class)
public class TodoCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoCoreApplication.class, args);


	}

//	@Bean
//	public CommandLineRunner initializeUser(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
//		return args -> {
//
//			User user = new User();
//			user.setUsername("exampleuser");
//			user.setEmail("example@gmail.com");
//			user.setPassword(passwordEncoder.encode("examplepassword"));
//
//			// Save the user to the database
//			userRepository.save(user);
//
//		};
//	}

}

package com.dev.tiago.fullstack_app.backend;

import com.dev.tiago.fullstack_app.backend.entity.User;
import com.dev.tiago.fullstack_app.backend.enums.UserRole;
import com.dev.tiago.fullstack_app.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

@SpringBootApplication
@RequiredArgsConstructor
public class Application implements CommandLineRunner {

	private final UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		User admin = new User();

		admin.setFirstName("admin");
		admin.setLastName("admin");
		admin.setEmail("admin@gmail.com");
		admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
		admin.setUserRole(UserRole.ADMIN);
		admin.setCreatedAt(new Date());

		userRepository.save(admin);
		 */


	}
}


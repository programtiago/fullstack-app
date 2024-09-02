package com.dev.tiago.fullstack_app.backend;

import com.dev.tiago.fullstack_app.backend.entity.User;
import com.dev.tiago.fullstack_app.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class Application implements CommandLineRunner {

	private static Logger logger = LoggerFactory.getLogger(Application.class);
	private final UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//Test if inserts on db
		User admin = new User();

		admin.setFirstName("Tiago");
		admin.setLastName("Silva");
		admin.setEmail("admin@gmail.com");
		admin.setUserRole("ADMIN");
		admin.setCreatedAt(new Date());

		if (userRepository.findByEmail(admin.getEmail()).isEmpty()){
			userRepository.save(admin);

			logger.info("User created sucessfully ");
		}

		logger.error("User not created. Email already registered");
	}
}

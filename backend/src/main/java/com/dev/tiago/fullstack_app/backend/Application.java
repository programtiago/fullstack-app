package com.dev.tiago.fullstack_app.backend;

import com.dev.tiago.fullstack_app.backend.entity.Device;
import com.dev.tiago.fullstack_app.backend.entity.Printer;
import com.dev.tiago.fullstack_app.backend.entity.User;
import com.dev.tiago.fullstack_app.backend.enums.UserRole;
import com.dev.tiago.fullstack_app.backend.repository.DeviceRepository;
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
	private final DeviceRepository deviceRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User admin = new User();

		admin.setFirstName("admin");
		admin.setLastName("admin");
		admin.setEmail("admin@gmail.com");
		admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
		admin.setUserRole(UserRole.ADMIN);
		admin.setCreatedAt(new Date());

		userRepository.save(admin);

		User user = new User();

		user.setFirstName("user");
		user.setLastName("user");
		user.setEmail("user@gmail.com");
		user.setPassword(new BCryptPasswordEncoder().encode("user"));
		user.setUserRole(UserRole.EMPLOYEE);
		user.setCreatedAt(new Date());


		Printer printer = new Printer();
		printer.setBrand("Toshiba");
		printer.setModel("BV-FV4-T");
		printer.setDescription("Toshiba BV-FV4-T 300 DPI");
		printer.setSection("Housing");
		printer.setFunction("Housing STB7");
		printer.setSerialNumber("2302PO000828");
		printer.setCategoryDevice("Printer");

		deviceRepository.save(printer);

	}
}


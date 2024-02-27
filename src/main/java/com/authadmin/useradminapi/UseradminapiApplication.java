package com.authadmin.useradminapi;

import com.authadmin.useradminapi.entity.Role;
import com.authadmin.useradminapi.entity.User;
import com.authadmin.useradminapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class UseradminapiApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;


	public static void main(String[] args) {
		SpringApplication.run(UseradminapiApplication.class, args);
	}

	public void run(String... args){
		User adminAccount = userRepository.findByRole(Role.ADMIN);
		if (adminAccount == null){
			User user = new User();
			user.setEmail("admin@example.com");
			user.setFirstName("Admin");
			user.setRole(Role.ADMIN);
			user.setLastName("Admin");
			user.setPassword(new BCryptPasswordEncoder().encode("admin@1234"));

			userRepository.save(user);
		}
	}

}

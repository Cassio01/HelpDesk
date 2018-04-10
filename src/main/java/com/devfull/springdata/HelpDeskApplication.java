package com.devfull.springdata;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.devfull.springdata.api.entity.User;
import com.devfull.springdata.api.enums.ProfileEnum;
import com.devfull.springdata.api.repository.UserRepository;

@SpringBootApplication
public class HelpDeskApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelpDeskApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(UserRepository usuarioRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			initUsers(usuarioRepository, passwordEncoder);
		};
	}
	
	private void initUsers(UserRepository usuarioRepository, PasswordEncoder passwordEncoder) {
		User admin = new User();
		admin.setEmail("cassio@helpdesk.com");
		admin.setPassword(passwordEncoder.encode("123456"));
		admin.setProfile(ProfileEnum.ROLE_ADMIN);
		
		User find = usuarioRepository.findByEmail("cassio@helpdesk.com");
		if(find == null) {
			usuarioRepository.save(admin);
		}
	}
}

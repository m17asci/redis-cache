package com.spring.test;

import com.spring.test.model.User;
import com.spring.test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.math.BigDecimal;
import java.util.Random;

@SpringBootApplication
@RequiredArgsConstructor
@EnableCaching
public class TestApplication  implements CommandLineRunner {
	private  final UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Random random = new Random();
		for (int i = 0; i<5000; i++){
			User user = new User();
			user.setName(String.valueOf(((random.nextDouble())*5000)));
			user.setSurname(String.valueOf(((random.nextDouble())*5000)));
			user.setTcIdentity(String.valueOf(((random.nextDouble())*5000)));
			user.setAccountBalance(BigDecimal.valueOf(((random.nextDouble())*5000)));

			//userRepository.save(user);

		}
	}
}

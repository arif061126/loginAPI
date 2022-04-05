package com.loginAPI;

import com.loginAPI.model.User;
import com.loginAPI.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Random;

@SpringBootApplication
public class LoginApiApplication implements CommandLineRunner {
	@Autowired
	private UserRepo userRepo;

	//@PostConstruct
	public void createUser(){
		int id = new Random().nextInt(100);
		User user = new User();
		user.setUsername("arif"+id);
		user.setPassword("1234");
		user.setUserEmail(user.getUsername()+id+"@gmail.com");
		user.setRole("ADMIN");

		User save = userRepo.save(user);

		System.out.println(save);
	}

	public static void main(String[] args){

		SpringApplication.run(LoginApiApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		createUser();
	}
}

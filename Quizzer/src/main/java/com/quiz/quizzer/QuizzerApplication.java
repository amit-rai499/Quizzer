package com.quiz.quizzer;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.quiz.quizzer.entity.Role;
import com.quiz.quizzer.entity.User;
import com.quiz.quizzer.entity.UserRole;
import com.quiz.quizzer.service.UserService;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class QuizzerApplication implements CommandLineRunner{
	
	@Autowired
	UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(QuizzerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		User user = new User();
//		user.setFirstName("Amit");
//		user.setLastName("Rai");
//		user.setUsername("amit.rai499");
//		user.setPassword(bCryptPasswordEncoder.encode("abc"));
//		user.setEmail("amit.rai499@gmail.com");
//		user.setPhone("8707575003");
//		user.setProfile("default.png");
//		Role role1= new Role();
//		role1.setRoleId(44L);
//		role1.setRoleName("ADMIN");
//		Set<UserRole> userRoleSet = new HashSet<>();
//		UserRole userRole = new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user);
//		userRoleSet.add(userRole);
//		this.userService.createUser(user, userRoleSet);
	}
	@Bean
	public Docket quizzerApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.quiz.quizzer")).paths(PathSelectors.any()).build();
	}

}

package com.quiz.quizzer.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.quizzer.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);

}

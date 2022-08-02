package com.quiz.quizzer.service;

import java.util.Set;
import java.util.UUID;

import com.quiz.quizzer.entity.User;
import com.quiz.quizzer.entity.UserRole;

public interface UserService {
	
	// creating user
	public User createUser(User user,Set<UserRole> userRoles) throws Exception;
	
	//getting user by username
	public User getUser(String username);
	
	//delete user by id
	public void deleteuser(Long userId);

}

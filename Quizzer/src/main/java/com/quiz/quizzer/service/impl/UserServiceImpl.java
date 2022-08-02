package com.quiz.quizzer.service.impl;

import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.quizzer.entity.User;
import com.quiz.quizzer.entity.UserRole;
import com.quiz.quizzer.exception.UserAlreadyExistsException;
import com.quiz.quizzer.repo.RoleRepository;
import com.quiz.quizzer.repo.UserRepository;
import com.quiz.quizzer.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		User local = this.userRepository.findByUsername(user.getUsername());
		if(local !=null) {
			throw new UserAlreadyExistsException("User is already present");
		}
		else {
			for(UserRole ur: userRoles) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);
		}
		return local;
	}
	
	//getting user by username
	@Override
	public User getUser(String username) {
		return this.userRepository.findByUsername(username);
	}

	@Override
	public void deleteuser(Long userId) {
		this.userRepository.deleteById(userId);
	}

}

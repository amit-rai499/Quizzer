package com.quiz.quizzer.exception;

@SuppressWarnings("serial")
public class UserNotFoundException extends Exception{

	public UserNotFoundException(String message) {
		super(message);
	}
}

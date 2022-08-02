package com.quiz.quizzer.service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.quiz.quizzer.entity.exam.Category;
import com.quiz.quizzer.entity.exam.Quiz;

public interface QuizService {
	
	public Quiz addQuiz(Quiz quiz);
	
	public Quiz updateQuiz(Quiz quiz);
	
	public Set<Quiz> getQuizzes();
	
	public Quiz getQuiz(Long quizId);
	
	public void deleteQuiz(Long quizId);
	
	public List<Quiz> getActiveQuizzesOfACategory(Category c);

}

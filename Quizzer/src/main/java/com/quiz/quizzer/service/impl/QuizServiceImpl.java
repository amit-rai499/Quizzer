package com.quiz.quizzer.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.quizzer.entity.exam.Category;
import com.quiz.quizzer.entity.exam.Quiz;
import com.quiz.quizzer.repo.QuizRepository;
import com.quiz.quizzer.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService{
	
	@Autowired
	private QuizRepository quizRepository;

	@Override
	public Quiz addQuiz(Quiz quiz) {
		return this.quizRepository.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		return this.quizRepository.save(quiz);
	}

	@Override
	public Set<Quiz> getQuizzes() {
		return new HashSet<>(this.quizRepository.findAll());
	}

	@Override
	public Quiz getQuiz(Long quizId) {
		return this.quizRepository.findById(quizId).get();
	}

	@Override
	public void deleteQuiz(Long quizId) {
		this.quizRepository.deleteById(quizId);	}
	
	
	// Get Quizzes of a category which are active 
	@Override
	public List<Quiz> getActiveQuizzesOfACategory(Category c) {
		return this.quizRepository.findByCategoryAndIsActive(c, true);
	}

}

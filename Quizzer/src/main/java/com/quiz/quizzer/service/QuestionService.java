package com.quiz.quizzer.service;

import java.util.Set;
import java.util.UUID;

import com.quiz.quizzer.entity.exam.Question;
import com.quiz.quizzer.entity.exam.Quiz;

public interface QuestionService {
	
	public Question addQuestion(Question question);
	
	public Question updateQuestion(Question question);
	
	public Set<Question> getQuestions(); 
	
	public Question getQuestion(Long questionId);
	
	public Set<Question> getQuestionsOfQuiz(Quiz quiz);
	
	public void deleteQuestion(Long quesId);
	
	public Question get(Long questionId);
}

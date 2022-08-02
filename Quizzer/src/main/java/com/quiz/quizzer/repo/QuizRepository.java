package com.quiz.quizzer.repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.quizzer.entity.exam.Category;
import com.quiz.quizzer.entity.exam.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long>{
	

	public List<Quiz> findByCategoryAndIsActive(Category c, boolean b);
}

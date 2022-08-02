package com.quiz.quizzer.repo;

import java.util.Set;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.quizzer.entity.exam.Question;
import com.quiz.quizzer.entity.exam.Quiz;

public interface QuestionRepository extends JpaRepository<Question, Long>{

	Set<Question> findByQuiz(Quiz quiz);


}

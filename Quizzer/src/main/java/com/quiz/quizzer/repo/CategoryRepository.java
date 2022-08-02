package com.quiz.quizzer.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.quizzer.entity.exam.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}

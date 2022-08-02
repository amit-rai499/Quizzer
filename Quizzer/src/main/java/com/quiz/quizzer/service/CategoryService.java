package com.quiz.quizzer.service;

import java.util.Set;
import java.util.UUID;

import com.quiz.quizzer.entity.exam.Category;

public interface CategoryService {
	
	public Category addCategory(Category category);
	
	public Category updateCategory(Category category);
	
	public Set<Category> getCategories();
	
	public Category getCategory(Long categoryId);
	
	public void deleteCategory (Long categoryId);

}

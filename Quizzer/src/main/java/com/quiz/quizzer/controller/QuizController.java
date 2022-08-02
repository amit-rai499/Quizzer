package com.quiz.quizzer.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.quizzer.entity.exam.Category;
import com.quiz.quizzer.entity.exam.Quiz;
import com.quiz.quizzer.service.QuizService;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	// add quiz
	@PostMapping("/")
	public ResponseEntity<Quiz> add(@RequestBody Quiz quiz){
		return ResponseEntity.ok(this.quizService.addQuiz(quiz));
	}
	
	//update quiz
	@PutMapping("/")
	public ResponseEntity<Quiz> update(@RequestBody Quiz quiz){
		return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
	}
	
	// get all quiz
	@GetMapping("/")
	public ResponseEntity<?> getQuizzes(){
		return ResponseEntity.ok(this.quizService.getQuizzes());
	}
	
	// get quiz by id
	@GetMapping("/{qId}")
	public Quiz quiz(@PathVariable("qId") Long qId) {
		return this.quizService.getQuiz(qId);
	}
	
	// delete quiz
	@DeleteMapping("/{qId}")
	public void delete(@PathVariable("qId") Long qId) {
		this.quizService.deleteQuiz(qId);
	}
	
	// Get Quizzes of a category which are active 
	@GetMapping("/category/{cid}")
	public ResponseEntity<?> getQuestionsOfAQuiz(@PathVariable("cid") Long cid){
		Category category = new Category();
		category.setCId(cid);
		List<Quiz> quizzes = quizService.getActiveQuizzesOfACategory(category);
		return ResponseEntity.ok(quizzes);
		}	
}

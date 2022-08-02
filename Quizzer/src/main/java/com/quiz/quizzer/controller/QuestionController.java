package com.quiz.quizzer.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

import com.quiz.quizzer.entity.exam.Question;
import com.quiz.quizzer.entity.exam.Quiz;
import com.quiz.quizzer.service.QuestionService;
import com.quiz.quizzer.service.QuizService;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@Autowired
	QuizService quizService;
	
	@PostMapping("/")
	public ResponseEntity<Question> add(@RequestBody Question question){
		return ResponseEntity.ok(this.questionService.addQuestion(question));
	}
	
	@PutMapping("/")
	public ResponseEntity<Question> update(@RequestBody Question question){
		return ResponseEntity.ok(this.questionService.updateQuestion(question));
	}
	
	// get all questions for a quiz
	@GetMapping("/quiz/{qId}")
	public ResponseEntity<?> getQuestionsOfAQuiz(@PathVariable("qId") Long qId){
		Quiz quiz  = this.quizService.getQuiz(qId);
		Set<Question> questions = quiz.getQuestions();
		List <Question> list = new ArrayList<Question>(questions);
		if(list.size() > Integer.parseInt(quiz.getNumberOfQuestions())) {
			list = list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions())+1);
		}
		list.forEach(q->{
			q.setAnswer(null);
		});
		Collections.shuffle(list);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/quiz/all/{qId}")
	public ResponseEntity<?> getAllQuestionsOfAQuiz(@PathVariable("qId") Long qId){
		Quiz quiz = new Quiz();
		quiz.setQId(qId);
		Set<Question> questionsOfQuiz = this.questionService.getQuestionsOfQuiz(quiz);
		return ResponseEntity.ok(questionsOfQuiz);
	}
	
	// get a question by id
	@GetMapping("/{quesId}")
	public Question getQuestion(@PathVariable("quesId") Long quesId) {
		return this.questionService.getQuestion(quesId);
	}
	
	@DeleteMapping("/{quesId}")
	public void deleteQuestion(@PathVariable("quesId") Long quesId) {
		this.questionService.deleteQuestion(quesId);
	}
	
	//eval quiz
	@PostMapping("/eval-quiz")public ResponseEntity<?> evalQuiz(@RequestBody List<Question> questions){
		double marksGot = 0 ;
		int correctAnswers = 0;
		int attempted = 0;
		for(Question q:questions){
			Question question =  this.questionService.get(q.getQuesId());
			if(question.getAnswer().equals(q.getGivenAnswer())) {
				correctAnswers++;
			}
			if(q.getGivenAnswer()!=null) {
				attempted++;
			}
			
		};
		double marksOfASingleQuestion = Double.parseDouble(questions.get(0).getQuiz().getMaxMarks())/questions.size();
		marksGot=marksOfASingleQuestion*correctAnswers;
		Map<String, Object> map = Map.of("marksGot",marksGot,"correctAnswers",correctAnswers,"attempted",attempted);
		return ResponseEntity.ok(map);
	}
	
}

package com.quiz.quizzer.entity.exam;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AccessLevel;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long quesId;
	
	@Column(length = Integer.MAX_VALUE)
	private String content;
	
	private String image;
	
	@Column(length = Integer.MAX_VALUE)
	private String option1;
	
	@Column(length = Integer.MAX_VALUE)
	private String option2;
	
	@Column(length = Integer.MAX_VALUE)
	private String option3;
	
	@Column(length = Integer.MAX_VALUE)
	private String option4;
	
	private String answer;
	
	@Transient
	private String givenAnswer;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Quiz quiz;	
	
}

package com.example.demo.Questionmodel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="QUESTIONS")
public class Question {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="QUESTION_ID")
	    private int questionId;
	    @Column(name="QUESTION_NUMBER")
	    private int questionNumber;
	    @Column(name="QUESTION_TEXT")
	    private String questionText;
	    @Column(name="CATEGORY")
	    private String category;
	    @Column(name="DIFFICULTY_LEVEL")
	    private  String difficultyLevel;
	    @Column(name="OPTION1 ")
	    private  String option1; 
	    @Column(name="OPTION2")
	    private  String option2;
	    @Column(name="OPTION3")
	    private  String option3;
	    @Column(name="RIGHT_ANSWER")
	    private  String rightAnswer;
}

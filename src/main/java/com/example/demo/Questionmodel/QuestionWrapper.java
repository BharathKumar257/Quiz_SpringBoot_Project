package com.example.demo.Questionmodel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
public class QuestionWrapper {
	@Id
	 private int questionId;
	 private String questionText;
	 private  String option1; 
	 private  String option2;
	 private  String option3;
}

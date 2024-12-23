package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.Questionmodel.Question;

public interface  QuestionService {
	
ResponseEntity<List<Question>> getallquestion();

ResponseEntity<String> createquestion(Question questions);

ResponseEntity<List<Question>> getbycategory(String category);

ResponseEntity<String> deletequestion(int quesid);
}

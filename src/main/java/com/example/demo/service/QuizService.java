package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.Questionmodel.QuestionWrapper;
import com.example.demo.Questionmodel.Response;

public interface QuizService {
ResponseEntity<String> createquiz(String category,int numQ,String tile);	
ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id);
ResponseEntity<Integer> calculateResult(int id,List<Response> responses);
}

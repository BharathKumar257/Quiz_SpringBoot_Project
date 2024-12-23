package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Questionmodel.QuestionWrapper;
import com.example.demo.Questionmodel.Response;
import com.example.demo.serviceimple.QuizImple;

@RestController
@RequestMapping(value="/Quiz")
public class QuizController {
	@Autowired
	QuizImple quizservice;
	@PostMapping(value="/create")
	public ResponseEntity<String> createquiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title){
		return quizservice.createquiz(category, numQ, title);
	}
	@GetMapping(value="get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestipns(@PathVariable Integer id){
		return quizservice.getQuizQuestions(id);
	}
	@PostMapping(value="/submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable int id,@RequestBody List<Response> responses){
		return quizservice.calculateResult(id, responses);
	}
	}

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Questionmodel.Question;
import com.example.demo.serviceimple.QuestionServiceImple;

@RestController
@RequestMapping(value="/QuestionInformation")
public class QuestionController {
	@Autowired
	QuestionServiceImple quesimpl;
	@GetMapping
	public ResponseEntity<List<Question>> getallquestions() {
		return quesimpl.getallquestion();
	}
	
	@GetMapping(value="/{category}")
	public ResponseEntity<List<Question>> getbycategory(@PathVariable String category){
		return quesimpl.getbycategory(category);
	}
	
	@PostMapping
	public ResponseEntity<String> createquestion(@RequestBody Question questions) {
		return quesimpl.createquestion(questions);
	}
	
    @DeleteMapping(value= "/{quesid}")
    public ResponseEntity<String> deletquestion(@PathVariable int quesid) {
    	return quesimpl.deletequestion(quesid);
  
    }
}



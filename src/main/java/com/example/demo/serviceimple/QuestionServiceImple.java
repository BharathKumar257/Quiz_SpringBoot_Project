package com.example.demo.serviceimple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.demo.Questionmodel.Question;
import com.example.demo.repo.QuestionRepo;
import com.example.demo.service.QuestionService;
@Component
public class QuestionServiceImple implements QuestionService {
  @Autowired
  QuestionRepo ques;
	@Override
	
	public ResponseEntity<List<Question>> getallquestion() {
		// TODO Auto-generated method stub
		try {
		return new ResponseEntity<>(ques.findAll(),HttpStatus.OK);
	}catch(Exception e) {
		e.printStackTrace();
	}
		return new ResponseEntity(new ArrayList<>(),HttpStatus.BAD_REQUEST );
	}

	@Override
	public ResponseEntity<String> createquestion(Question questions) {
		// TODO Auto-generated method stub
	try {
	ques.save(questions);
	return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
		return new ResponseEntity(new ArrayList<>(),HttpStatus.BAD_REQUEST );
	}

	@Override
	public ResponseEntity<String> deletequestion(int quesid) {
		// TODO Auto-generated method stub
		try {
		Optional<Question> byId = ques.findById(quesid);
		if(byId.isPresent()) {
		  Question question = byId.get();
          ques.delete(question);
		}
		return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
			return new ResponseEntity(new ArrayList<>(),HttpStatus.BAD_REQUEST );
		}


	@Override
	public ResponseEntity<List<Question>> getbycategory(String category) {
		// TODO Auto-generated method stub
		try {
		return new ResponseEntity<>(ques.findByCategory(category),HttpStatus.OK);
	}catch(Exception e) {
		e.printStackTrace();
	}
		return new ResponseEntity(new ArrayList<>(),HttpStatus.BAD_REQUEST );

}
}

package com.example.demo.serviceimple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Questionmodel.Question;
import com.example.demo.Questionmodel.QuestionWrapper;
import com.example.demo.Questionmodel.Quiz;
import com.example.demo.Questionmodel.Response;
import com.example.demo.repo.QuestionRepo;
import com.example.demo.repo.QuizRepo;
import com.example.demo.service.QuizService;

import jakarta.transaction.Transactional;

@Service
public class QuizImple implements QuizService{
	@Autowired
	QuizRepo quizrepo;
    @Autowired
    QuestionRepo quesrepo;
    @Transactional
	@Override
	public ResponseEntity<String> createquiz(String category, int numQ, String tile) {
		// TODO Auto-generated method stub
		try {
		List<Question> questions=quesrepo.findRandomQuestionsByCategory(category,numQ);
		
		Quiz quiz=new Quiz();
		quiz.setTitle(tile);
		quiz.setQuestions(questions);
		quizrepo.save(quiz);
		return new ResponseEntity<>("Success",HttpStatus.OK);
	}catch(Exception e) {
		e.printStackTrace();
	}
		return new ResponseEntity(new ArrayList<>(),HttpStatus.BAD_REQUEST );
	}
	@Override
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
		// TODO Auto-generated method stub
		Optional<Quiz> byId = quizrepo.findById(id);
		List<Question> questionsfromDB =byId.get().getQuestions();
		List<QuestionWrapper> questionsforUsers = new ArrayList<>();
		for (Question q: questionsfromDB){
			QuestionWrapper qw= new QuestionWrapper(q.getQuestionId(),q.getQuestionText(),q.getOption1(),q.getOption2(),q.getOption3());
			questionsforUsers.add(qw);
		}
		
		return new ResponseEntity<>(questionsforUsers,HttpStatus.OK);
	}
	@Override
	public ResponseEntity<Integer> calculateResult(int id, List<Response> responses) {
		// TODO Auto-generated method stub
		Quiz quiz=quizrepo.findById(id).get();
		List<Question> questions=quiz.getQuestions();
		int rightAnswer=0;
		int i=0;
		for (Response re : responses) {
			if(re.getResponse().equals(questions.get(i).getRightAnswer()))
				rightAnswer++;
				i++;
		}
		return new ResponseEntity(rightAnswer,HttpStatus.OK);
	}

}
package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Questionmodel.Quiz;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Integer> {
	

}

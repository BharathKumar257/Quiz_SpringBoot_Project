package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Questionmodel.Question;
@Repository

public interface QuestionRepo extends JpaRepository<Question, Integer> {
	 @Query("SELECT q FROM Question q WHERE q.category = :category")
	 List<Question> findByCategory(@Param("category") String category);
	
	 @Query(value = "SELECT * FROM questions q Where q.category=:category ORDER BY RAND() LIMIT :numQ  ", nativeQuery = true)
	 List<Question> findRandomQuestionsByCategory(@Param("category")String category, @Param("numQ") int numQ);




}

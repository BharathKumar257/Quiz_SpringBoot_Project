package com.example.demo.Questionmodel;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="QUIZ")
public class Quiz {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="ID")
private Integer id;
@Column(name="TITLE")
private String title;

@ManyToMany(cascade = CascadeType.ALL)
@JoinTable(
	    joinColumns = @JoinColumn(name = "id"),
	    inverseJoinColumns = @JoinColumn(name = "questionId")
	)
private List<Question> questions;
}

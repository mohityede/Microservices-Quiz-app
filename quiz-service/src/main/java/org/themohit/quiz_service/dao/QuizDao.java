package org.themohit.quiz_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.themohit.quiz_app.model.Question;
import org.themohit.quiz_app.model.Quiz;

import java.util.List;

@Repository
public interface QuizDao extends JpaRepository<Quiz,Integer> {

}

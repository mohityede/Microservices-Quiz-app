package org.themohit.question_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.themohit.question_service.model.Question;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {
    List<Question> findByCategory(String category);

    @Query(value = "SELECT q.id FROM questions q WHERE q.category=:category ORDER BY RAND() LIMIT :quesCount",nativeQuery = true)
    List<Integer> getRandomQuizByCategory(String category, int quesCount);
}

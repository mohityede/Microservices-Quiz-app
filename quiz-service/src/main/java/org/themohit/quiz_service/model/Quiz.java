package org.themohit.quiz_service.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @ElementCollection
    private List<Integer> questionId;

    public Quiz() {
    }

    public Quiz(int id) {
        this.id = id;
    }

    public Quiz(String title, List<Integer> questionId) {
        this.title = title;
        this.questionId = questionId;
    }

    public Quiz(int id, String title, List<Integer> questionId) {
        this.id = id;
        this.title = title;
        this.questionId = questionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Integer> getQuestionId() {
        return questionId;
    }

    public void setQuestions(List<Integer> questionId) {
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", questionId=" + questionId +
                '}';
    }
}

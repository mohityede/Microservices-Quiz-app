package org.themohit.quiz_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    private int id;
    private String question;
    private String category;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private char correctoption;
    private String difficulty;

    public Question() {
    }

    public Question(int id) {
        this.id = id;
    }

    public Question(int id, String question, String category, String optionA, String optionB, String optionC, String optionD, char correctoption, String difficulty) {
        this.id = id;
        this.question = question;
        this.category = category;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctoption = correctoption;
        this.difficulty = difficulty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public char getCorrectOpton() {
        return correctoption;
    }

    public void setCorrectOpton(char correctoption) {
        this.correctoption = correctoption;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", category='" + category + '\'' +
                ", optionA='" + optionA + '\'' +
                ", optionB='" + optionB + '\'' +
                ", optionC='" + optionC + '\'' +
                ", optionD='" + optionD + '\'' +
                ", correctoption=" + correctoption +
                ", difficulty='" + difficulty + '\'' +
                '}';
    }
}
package org.themohit.quiz_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.themohit.quiz_service.model.QuestionWrapper;
import org.themohit.quiz_service.model.Quiz;
import org.themohit.quiz_service.model.UserReqBody;
import org.themohit.quiz_service.model.UserResponse;
import org.themohit.quiz_service.service.QuizService;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService service;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestBody UserReqBody body){
        return service.createQuiz(body.getTitle(),body.getCategory(),body.getQuesCount());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Quiz>> getAllQuiz(){
        return service.getAllQuiz();
    }

    @GetMapping("/questions/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizById(@PathVariable int id){
        return service.getQuizQuestionsById(id);
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> getScore(@PathVariable int id,@RequestBody List<UserResponse> res){
        return service.getScore(id,res);
    }
}

package org.themohit.quiz_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.themohit.quiz_app.model.QuestionWrapper;
import org.themohit.quiz_app.model.Quiz;
import org.themohit.quiz_app.model.UserResponse;
import org.themohit.quiz_app.service.QuizService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService service;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String title,
                                            @RequestParam String category,
                                             @RequestParam int quesCount){
        return service.createQuiz(title,category,quesCount);
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

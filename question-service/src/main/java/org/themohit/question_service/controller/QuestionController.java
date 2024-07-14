package org.themohit.question_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.themohit.question_service.model.Question;
import org.themohit.question_service.model.QuestionWrapper;
import org.themohit.question_service.model.UserResponse;
import org.themohit.question_service.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService service;
    @GetMapping("/allQuestion")
    public ResponseEntity<List<Question>> getHome(){
        return service.getAllQues();
    }

    @GetMapping("/category/{cat}")
    public ResponseEntity<List<Question>> getQuesByCat(@PathVariable(name = "cat") String category){
        return service.getQuestionByCat(category);
    }

    @PostMapping("/add")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
        return service.addQuestion(question);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateQuestion(@RequestBody Question question){
        return service.updateQuestions(question);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int id){
        return service.deleteQuestionById(id);
    }

    @PostMapping("/generate")
    public ResponseEntity<List<Integer>> generateQuiz(@RequestParam String category, @RequestParam int quesCount){
        return service.generateQuiz(category,quesCount);
    }

    @PostMapping("/get/question")
    public ResponseEntity<List<QuestionWrapper>> getQuestions(@RequestBody List<Integer> questionIds){
        return service.getQuestionsForQuiz(questionIds);
    }

    @PostMapping("/result")
    public ResponseEntity<Integer> getResult(@RequestBody List<UserResponse> response){
        return service.calculateResult(response);
    }

}

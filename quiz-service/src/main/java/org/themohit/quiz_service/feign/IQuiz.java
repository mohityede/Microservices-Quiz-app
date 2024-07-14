package org.themohit.quiz_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.themohit.quiz_service.model.QuestionWrapper;
import org.themohit.quiz_service.model.UserResponse;

import java.util.List;

@FeignClient("QUESTION-SERVICE/question")
public interface IQuiz {
    @PostMapping("/generate")
    public ResponseEntity<List<Integer>> generateQuiz
            (@RequestParam String category, @RequestParam int quesCount);

    @PostMapping("/get/question")
    public ResponseEntity<List<QuestionWrapper>> getQuestions
            (@RequestBody List<Integer> questionIds);

    @PostMapping("/result")
    public ResponseEntity<Integer> getResult(@RequestBody List<UserResponse> response);
}

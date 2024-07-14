package org.themohit.question_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.themohit.question_service.dao.QuestionDao;
import org.themohit.question_service.model.Question;
import org.themohit.question_service.model.QuestionWrapper;
import org.themohit.question_service.model.UserResponse;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQues(){
        try{
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionByCat(String category) {
        return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
    }

    public ResponseEntity<Question> addQuestion(Question question) {
        return new ResponseEntity<>(questionDao.save(question),HttpStatus.CREATED);
    }

    public ResponseEntity<String> updateQuestions(Question question) {
        return new ResponseEntity<>(questionDao.save(question).getId()+" ID updated successfully!",HttpStatus.OK);
    }

    public ResponseEntity<String> deleteQuestionById(int id) {
        questionDao.deleteById(id);
        return new ResponseEntity<>(id+" deleted successfully!",HttpStatus.OK);
    }

    public ResponseEntity<List<Integer>> generateQuiz(String category, int quesCount) {
        return new ResponseEntity<>(questionDao.getRandomQuizByCategory(category,quesCount),HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionsForQuiz(List<Integer> questionsIds){
        List<QuestionWrapper> res=new ArrayList<>();
        for(Integer id:questionsIds){
            Question question=questionDao.findById(id).get();
            QuestionWrapper wrapper=new QuestionWrapper(question.getId(),
                    question.getQuestion(),
                    question.getOptionA(),
                    question.getOptionB(),
                    question.getOptionC(),
                    question.getOptionD());
            res.add(wrapper);
        }
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(List<UserResponse> responses) {
        Integer result=0;
        for(UserResponse response:responses){
            Question question=questionDao.findById(response.getId()).get();
            if(question.getCorrectOpton()==response.getResponse()){
                result++;
            }
        }
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}

package org.themohit.quiz_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.themohit.quiz_service.dao.QuizDao;
import org.themohit.quiz_service.feign.IQuiz;
import org.themohit.quiz_service.model.Question;
import org.themohit.quiz_service.model.QuestionWrapper;
import org.themohit.quiz_service.model.Quiz;
import org.themohit.quiz_service.model.UserResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    private QuizDao quizDao;
    @Autowired
    private IQuiz iQuiz;

    public ResponseEntity<String> createQuiz(String title, String category, int quesCount) {
        try{
            List<Integer> randomQuestions= iQuiz.generateQuiz(category,quesCount).getBody();
            Quiz newQuiz=new Quiz(title,randomQuestions);
            quizDao.save(newQuiz);
//            List<Question> randomQuestions= new ArrayList<>();//questionDao.getRandomQuizByCategory(category,quesCount);
//            Quiz newQuiz = new Quiz(title, randomQuestions);
//            quizDao.save(newQuiz);
            return new ResponseEntity<>(newQuiz.getTitle()+" quiz created", HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Some issue with server",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<List<Quiz>> getAllQuiz(){
        return new ResponseEntity<>(quizDao.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestionsById(int id) {
        List<Integer> quesIds= quizDao.findById(id).get().getQuestionId();
//        List<Question> dbQuestions= dbQuiz.get().getQuestions();
        List<QuestionWrapper> userQuestions= iQuiz.getQuestions(quesIds).getBody();
//        for(Question q:dbQuestions){
//            userQuestions.add(new QuestionWrapper(q.getId(),
//                    q.getQuestion(),
//                    q.getOptionA(),
//                    q.getOptionB(),
//                    q.getOptionC(),
//                    q.getOptionD()));
//        }
        return new ResponseEntity<>(userQuestions,HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(int id, List<UserResponse> res) {
//        Optional<Quiz> dbQuiz=quizDao.findById(id);
//        List<Question> dbQuestion = dbQuiz.get().getQuestions();
//        Collections.sort(dbQuestion,(a,b)->(a.getId()-b.getId()));
//        Collections.sort(res,(a,b)->(a.getId()-b.getId()));
        int score= iQuiz.getResult(res).getBody();
//        for(int i=0;i<dbQuestion.size();i++){
//            if(res.get(i).getResponse() == dbQuestion.get(i).getCorrectOpton()){
//                score++;
//            }
//        }
        return new ResponseEntity<>(score,HttpStatus.OK);
    }
}

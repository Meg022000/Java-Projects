package com.maaggiii.QuizService.service;


import com.maaggiii.QuizService.Entity.Quiz;
import com.maaggiii.QuizService.Entity.questionwrapper;
import com.maaggiii.QuizService.Entity.response;
import com.maaggiii.QuizService.Feign.QuizInterface;
import com.maaggiii.QuizService.Repository.QuizDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class quizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;
//    @Autowired
//    QuestionDao questionDao;

    public ResponseEntity<String> createquiz(String category, int numQ, String title) {
        List<Integer> questions= quizInterface.generateQuestion(category,numQ).getBody();

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("success", HttpStatus.CREATED);



    }

    public ResponseEntity<List<questionwrapper>> getQuizQuestions(Integer id) {
        Quiz quiz =quizDao.findById(id).get();
        List<Integer> questionIds = quiz.getQuestionIds();
        ResponseEntity<List<questionwrapper>> questions = quizInterface.getQuestionsFromId(questionIds);
        return questions;
    }


    public ResponseEntity<Integer> getscore(Integer id, List<response> responses) {
      ResponseEntity<Integer> score= quizInterface.getScore(responses);
        return (score);
    }
}


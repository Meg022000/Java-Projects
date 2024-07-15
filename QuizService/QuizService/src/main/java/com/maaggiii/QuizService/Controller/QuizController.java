package com.maaggiii.QuizService.Controller;


import com.maaggiii.QuizService.Entity.questionwrapper;
import com.maaggiii.QuizService.Entity.quizDto;
import com.maaggiii.QuizService.Entity.response;
import com.maaggiii.QuizService.service.quizService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
@RequiredArgsConstructor
public class QuizController {

    @Autowired
    quizService QuizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestBody quizDto quizDto) {
        return  QuizService.createquiz(quizDto.getCategory(), quizDto.getNumQ(), quizDto.getTitle());


    }
    @GetMapping("/start/{id}")
    public ResponseEntity<List<questionwrapper>> getQuiz(@PathVariable Integer id) {
        return QuizService.getQuizQuestions(id);
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<response> Response) {
        return QuizService.getscore(id, Response);
    }

}

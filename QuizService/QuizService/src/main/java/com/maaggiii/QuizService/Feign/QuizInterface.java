package com.maaggiii.QuizService.Feign;

import com.maaggiii.QuizService.Entity.questionwrapper;
import com.maaggiii.QuizService.Entity.response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
    @GetMapping("question/generate")
    public ResponseEntity<List<Integer>> generateQuestion(@RequestParam String Category, @RequestParam Integer numberOfQuestions);

    @PostMapping("question/getQuestions")
    public ResponseEntity<List<questionwrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds);


    @PostMapping("question/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<response> responses);

}

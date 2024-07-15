package com.maaggiii.QuizService.Repository;

import com.maaggiii.QuizService.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz, Integer> {

}

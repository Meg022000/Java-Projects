package com.maaggiii.QuizService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class response {

    @Id
    private int id;
    private String response;
}

package com.maaggiii.QuizService.Entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Quiz {

    @Id
    private int id;
    private String title;

    @ElementCollection
    private List<Integer> questionIds;

}

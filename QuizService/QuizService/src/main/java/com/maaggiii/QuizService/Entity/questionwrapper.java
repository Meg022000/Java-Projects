package com.maaggiii.QuizService.Entity;

import lombok.Data;

@Data

public class questionwrapper {

    private    Integer id;
    private    String questionTitle;
    private    String questionText;
    private    String option1;
    private    String option2;
    private    String option3;
    private    String option4;

    public questionwrapper(Integer id, String questionTitle, String questionText, String option1, String option2, String option3, String option4) {
        this.id=id;
        this.questionTitle = questionTitle;
        this.questionText = questionText;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }


}

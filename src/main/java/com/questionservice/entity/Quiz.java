package com.questionservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Quiz
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String Category;

    private int noOfQue;

    @ManyToMany
    @JoinTable(name = "quiz_questions_list")
    private List<Questions> questionsList;

}

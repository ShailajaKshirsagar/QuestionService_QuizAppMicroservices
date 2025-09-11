package com.questionservice.service;


import com.questionservice.dto.QuizQuestionDto;
import com.questionservice.entity.Questions;
import com.questionservice.request.Quizrequest;

import java.util.List;

public interface QuestionService
{
    //getallwue
    List<Questions> getAllQue();

    //get random questions by input
    List<Integer> getRandomQuestions(int noofque, String category);

    // get list of questions by id
    List<QuizQuestionDto> getListOfQuestionById(List<Integer> queId);

    //get result method
    int getResult(List<Quizrequest> quizrequest);
}

package com.questionservice.service;


import com.questionservice.dto.QuizQuestionDto;
import com.questionservice.entity.Questions;
import com.questionservice.request.Quizrequest;

import java.util.List;

public interface QuestionService
{
    List<Questions> getAllQue();

    List<Integer> getRandomQuestions(int noofque, String category);

    List<QuizQuestionDto> getListOfQuestionById(List<Integer> queId);

    int getResult(List<Quizrequest> quizrequest);
}

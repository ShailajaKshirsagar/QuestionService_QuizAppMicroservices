package com.questionservice.serviceImpl;

import com.questionservice.dto.QuizQuestionDto;
import com.questionservice.entity.Questions;
import com.questionservice.repository.QuestionRepository;
import com.questionservice.request.Quizrequest;
import com.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService
{
    @Autowired
    private QuestionRepository questionRepository;

    //get all questions method
    @Override
    public List<Questions> getAllQue() {

        List<Questions> questionsList = questionRepository.findAll();
        return questionsList;
    }


    //get random questions
    @Override
    public List<Integer> getRandomQuestions(int noofque, String category) {

        List<Questions> randomQuestion = questionRepository.findRandomQuestion(noofque,category);

        List<Integer> questionId = new ArrayList<>();
        for(Questions q :randomQuestion){
            questionId.add(q.getId());
        }
        return questionId;
    }

    //getlistofquestion
    @Override
    public List<QuizQuestionDto> getListOfQuestionById(List<Integer> queId) {
        List<QuizQuestionDto> list = new ArrayList<>();
        for(int id : queId){
            Questions q = questionRepository.findById(id).get();
            QuizQuestionDto dto = new QuizQuestionDto(q.getId(),q.getQuestion(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            list.add(dto);
        }
        return list;
    }

    //get result
    @Override
    public int getResult(List<Quizrequest> quizrequest) {

        int correctAns = 0;
        for(Quizrequest q : quizrequest){
            Questions question = questionRepository.findById(q.getQueId()).get();
            if(question.getCorrect_option() == q.getSelectedOption()){
                correctAns++;
            }
        }
        return correctAns;
    }
}

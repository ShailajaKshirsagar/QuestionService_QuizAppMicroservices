package com.questionservice.controller;

import com.questionservice.dto.QuizQuestionDto;
import com.questionservice.entity.Questions;
import com.questionservice.request.Quizrequest;
import com.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionsController
{
    @Autowired
    private QuestionService questionService;

    //get all questions api
    @GetMapping("/getAllQuestions")
    public ResponseEntity<List<Questions>> getAllQuestions(){
        List<Questions> questionsList = questionService.getAllQue();
        return new ResponseEntity<>(questionsList, HttpStatus.OK);
    }

    //get questions api
    @GetMapping("/getQuestions")
    public ResponseEntity<List<Integer>> getQuestionList(@RequestParam(name = "noofque") int noofque,
                                                         @RequestParam(name = "category")String category){

        List<Integer> questions = questionService.getRandomQuestions(noofque,category);
        return new ResponseEntity<>(questions,HttpStatus.OK);
    }

    //getquestions by id .
    //use requestparam for getmapping and requestbody for postmapping
    @PostMapping("/getQuestionsByQuestionId")
    public ResponseEntity<List<QuizQuestionDto>> getQuestionByQUeId(@RequestBody List<Integer> queId){
      List<QuizQuestionDto> questionDtoList = questionService.getListOfQuestionById(queId);
      return new ResponseEntity<>(questionDtoList,HttpStatus.OK);
    }

    //submit or getresult
    @PostMapping("/getResult")
    public ResponseEntity<Integer> getResult(@RequestBody List<Quizrequest> quizrequest){
        int result = questionService.getResult(quizrequest);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}

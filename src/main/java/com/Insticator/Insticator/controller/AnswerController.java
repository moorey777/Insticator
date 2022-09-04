package com.Insticator.Insticator.controller;

import com.Insticator.Insticator.mapper.AnswerMapper;
import com.Insticator.Insticator.model.Answer;
import com.Insticator.Insticator.model.Trivia;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/answer")
public class AnswerController {
    private AnswerMapper answerMapper;
    public AnswerController(AnswerMapper answerMapper) {
        this.answerMapper = answerMapper;
    }

    @GetMapping("/all")
    public List<Answer> getAll() {
        return answerMapper.findAll();
    }

    // actual update controller
    @PostMapping("/update")
    public boolean update(@RequestBody Answer answer) {
        boolean res = false;
        // if the answer is trivia answer, it has to check the correctness
        if(answer.getTypeId() == 1) {
            Trivia correct = getCorrectTrivia(answer);

            if(correct.getAnswer().equals(answer.getAnswer())) res = true;
            else res = false;

            answer.setCorrect(res);
        }

        answerMapper.insert(answer);

        return res;
    }

    // test update controller
//    @PostMapping("/update")
//    public List<Answer> update(@RequestBody Answer answer) {
//        boolean res = false;
//        // if the answer is trivia answer, it has to check the correctness
//        if(answer.getTypeId() == 1) {
//            Trivia correct = getCorrectTrivia(answer);
//
//            if(correct.getAnswer().equals(answer.getAnswer())) res = true;
//            else res = false;
//
//            answer.setCorrect(res);
//        }
//
//        answerMapper.insert(answer);
//
//        return answerMapper.findAll();
//    }

    private Trivia getCorrectTrivia(Answer answer) {
        String typeName = answerMapper.findTypeName(answer.getTypeId());
        return answerMapper.find(typeName, answer.getQuestionId());
    }
}
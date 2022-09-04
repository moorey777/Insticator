package com.Insticator.Insticator.controller;

import com.Insticator.Insticator.mapper.AnswerMapper;
import com.Insticator.Insticator.model.Answer;
import com.Insticator.Insticator.model.Trivia;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RestController
class AnswerControllerTest {

    @Resource
    private AnswerController answerController;
    @Test
    void update() {
        // Trivia test case1: choose correct answer
        Answer answer1 = new Answer();
        answer1.setTypeId(1);
        answer1.setQuestionId(1);
        answer1.setAnswer("B");
        answer1.setUserUid("c4473c54-2bda-11ed-a261-0242ac120002");

        boolean response1 = answerController.update(answer1);
        assertEquals(response1, true);


        // Trivia test case2: choose false answer
        Answer answer2 = new Answer();
        answer2.setTypeId(1);
        answer2.setQuestionId(1);
        answer2.setAnswer("A");
        answer2.setUserUid("c4473c54-2bda-11ed-a261-0242ac120002");

        boolean response = answerController.update(answer2);
        assertEquals(response, false);
    }
}
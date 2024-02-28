package dev.nj.webquiz.services.impl;

import dev.nj.webquiz.entities.Quiz;
import dev.nj.webquiz.entities.Result;
import dev.nj.webquiz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    Quiz quiz;

    @Override
    public Quiz getQuiz() {
        return quiz;
    }

    @Override
    public Result answerQuiz(int index) {
        return new Result(index == quiz.getAnswer());
    }
}

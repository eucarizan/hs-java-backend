package dev.nj.webquiz.services;

import dev.nj.webquiz.entities.Quiz;
import dev.nj.webquiz.entities.Result;

public interface QuizService {

    Quiz getQuiz();

    Result answerQuiz(int index);
}

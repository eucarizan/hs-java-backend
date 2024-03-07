package dev.nj.webquiz.services;

import dev.nj.webquiz.entities.Quiz;
import dev.nj.webquiz.entities.Result;

import java.util.List;

public interface QuizService {

    Quiz getQuiz(long index);

    Result answerQuiz(long index, int answer);

    Quiz createQuiz(Quiz quiz);

    Iterable<Quiz> getQuizzes();
}

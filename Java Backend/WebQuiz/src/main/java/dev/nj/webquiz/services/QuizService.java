package dev.nj.webquiz.services;

import dev.nj.webquiz.entities.Quiz;
import dev.nj.webquiz.entities.Result;
import dev.nj.webquiz.web.dto.AnswerDto;

public interface QuizService {

    Quiz getQuiz(long index);

    Result answerQuiz(long index, AnswerDto answer);

    Quiz createQuiz(Quiz quiz);

    Iterable<Quiz> getQuizzes();
}

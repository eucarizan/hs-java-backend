package dev.nj.webquiz.services;

import dev.nj.webquiz.entities.Quiz;
import dev.nj.webquiz.entities.Result;
import dev.nj.webquiz.entities.User;
import dev.nj.webquiz.web.dto.AnswerDto;
import dev.nj.webquiz.web.dto.QuizDto;

public interface QuizService {

    Quiz getQuiz(long index);

    Result answerQuiz(long index, AnswerDto answer);

    Quiz createQuiz(QuizDto quizDto, User user);

    Iterable<Quiz> getQuizzes();
}

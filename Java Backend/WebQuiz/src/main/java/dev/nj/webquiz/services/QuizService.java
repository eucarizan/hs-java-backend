package dev.nj.webquiz.services;

import dev.nj.webquiz.entities.Quiz;
import dev.nj.webquiz.entities.Result;
import dev.nj.webquiz.entities.User;
import dev.nj.webquiz.web.dto.AnswerDto;

public interface QuizService {

    Quiz getQuiz(long index, User user);

    Result answerQuiz(long index, AnswerDto answer, User user);

    Quiz createQuiz(Quiz quiz, User user);

    Iterable<Quiz> getQuizzes(User user);
}

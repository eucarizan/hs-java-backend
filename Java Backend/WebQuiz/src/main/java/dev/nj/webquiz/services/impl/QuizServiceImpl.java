package dev.nj.webquiz.services.impl;

import dev.nj.webquiz.entities.Quiz;
import dev.nj.webquiz.entities.Result;
import dev.nj.webquiz.entities.User;
import dev.nj.webquiz.exceptions.NotOwnerException;
import dev.nj.webquiz.exceptions.QuizNotFoundException;
import dev.nj.webquiz.repositories.QuizRepository;
import dev.nj.webquiz.services.QuizService;
import dev.nj.webquiz.web.dto.AnswerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.function.Consumer;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository repository;

    @Autowired
    public QuizServiceImpl(QuizRepository repository) {
        this.repository = repository;
    }

    @Override
    public Quiz getQuiz(long index, User user) throws QuizNotFoundException {
        return repository.findById(index).orElseThrow(QuizNotFoundException::new);
    }

    @Override
    public Result answerQuiz(long index, AnswerDto answer, User user) throws QuizNotFoundException{
        Quiz quiz = getQuiz(index, user);
        boolean isCorrect = Arrays.equals(
                Arrays.stream(answer.answer()).sorted().toArray(),
                Arrays.stream(quiz.getAnswer()).sorted().toArray());
        return new Result(isCorrect);
    }

    @Override
    public Quiz createQuiz(Quiz quiz, User user) {
        //TODO: quizmapper include user/creator
        return repository.save(quiz);
    }

    @Override
    public Iterable<Quiz> getQuizzes(User user) {
        return repository.findAll();
    }

    private void executeIfOwnerOrThrow(Quiz quiz, Consumer<Quiz> action, String username) throws NotOwnerException {
        if (quiz.getCreator().getUsername().equals(username)) {
            action.accept(quiz);
        } else {
            throw new NotOwnerException();
        }
    }
}

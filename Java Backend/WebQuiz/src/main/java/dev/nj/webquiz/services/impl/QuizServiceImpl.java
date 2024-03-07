package dev.nj.webquiz.services.impl;

import dev.nj.webquiz.entities.Quiz;
import dev.nj.webquiz.entities.Result;
import dev.nj.webquiz.exceptions.QuizNotFoundException;
import dev.nj.webquiz.repositories.QuizRepository;
import dev.nj.webquiz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository repository;

    @Autowired
    public QuizServiceImpl(QuizRepository repository) {
        this.repository = repository;
    }

    @Override
    public Quiz getQuiz(long index) throws QuizNotFoundException {
        return repository.findById(index).orElseThrow(QuizNotFoundException::new);
    }

    @Override
    public Result answerQuiz(long index, int answer) throws QuizNotFoundException{
        Quiz quiz = getQuiz(index);
        return new Result(answer == quiz.getAnswer());
    }

    @Override
    public Quiz createQuiz(Quiz quiz) {
        return repository.save(quiz);
    }

    @Override
    public Iterable<Quiz> getQuizzes() {
        return repository.findAll();
    }
}

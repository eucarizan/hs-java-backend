package dev.nj.webquiz.services.impl;

import dev.nj.webquiz.entities.Quiz;
import dev.nj.webquiz.entities.Result;
import dev.nj.webquiz.entities.User;
import dev.nj.webquiz.exceptions.NotOwnerException;
import dev.nj.webquiz.exceptions.QuizNotFoundException;
import dev.nj.webquiz.repositories.QuizRepository;
import dev.nj.webquiz.services.QuizService;
import dev.nj.webquiz.web.dto.AnswerDto;
import dev.nj.webquiz.web.dto.QuizDto;
import dev.nj.webquiz.web.mapper.QuizMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.function.Consumer;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository repository;
    private final QuizMapper mapper;

    @Autowired
    public QuizServiceImpl(QuizRepository repository, QuizMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

//    public Quiz getQuiz(long index, User user) throws QuizNotFoundException, NotOwnerException {
//        Quiz quiz = repository.findById(index).orElseThrow(QuizNotFoundException::new);
//
//        if (!quiz.getCreator().equals(user)) {
//            throw new NotOwnerException();
//        }
//
//        return quiz;
//    }

    @Override
    public Quiz getById(long id) throws QuizNotFoundException {
        return repository.findById(id).orElseThrow(QuizNotFoundException::new);
    }

    @Override
    public Result answer(long id, AnswerDto answer) throws QuizNotFoundException {
        Quiz quiz = getById(id);
        boolean isCorrect = Arrays.equals(
                Arrays.stream(answer.answer()).sorted().toArray(),
                Arrays.stream(quiz.getAnswer()).sorted().toArray());
        return new Result(isCorrect);
    }

    @Override
    public Quiz create(QuizDto quizDto, User user) {
        return repository.save(mapper.toEntity(quizDto, user));
    }

    @Override
    public Iterable<Quiz> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(long id, String username) {
        repository.findById(id)
                .ifPresentOrElse(quiz -> executeIfOwnerOrThrow(quiz, repository::delete, username),
                        () -> {
                            throw new QuizNotFoundException();
                        });
    }

    private void executeIfOwnerOrThrow(Quiz quiz, Consumer<Quiz> action, String username) throws NotOwnerException {
        if (quiz.getCreator().getUsername().equals(username)) {
            action.accept(quiz);
        } else {
            throw new NotOwnerException();
        }
    }
}

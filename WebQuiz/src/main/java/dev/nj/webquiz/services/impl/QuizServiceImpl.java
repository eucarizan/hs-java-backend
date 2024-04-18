package dev.nj.webquiz.services.impl;

import dev.nj.webquiz.entities.Quiz;
import dev.nj.webquiz.entities.Result;
import dev.nj.webquiz.entities.Success;
import dev.nj.webquiz.entities.User;
import dev.nj.webquiz.exceptions.NotOwnerException;
import dev.nj.webquiz.exceptions.QuizNotFoundException;
import dev.nj.webquiz.repositories.QuizRepository;
import dev.nj.webquiz.repositories.SuccessRepository;
import dev.nj.webquiz.services.QuizService;
import dev.nj.webquiz.web.dto.AnswerDto;
import dev.nj.webquiz.web.dto.QuizDto;
import dev.nj.webquiz.web.dto.SuccessDto;
import dev.nj.webquiz.web.mapper.QuizMapper;
import dev.nj.webquiz.web.mapper.SuccessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.function.Consumer;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;
    private final SuccessRepository successRepository;
    private final QuizMapper quizMapper;
    private final SuccessMapper successMapper;

    @Autowired
    public QuizServiceImpl(QuizRepository repository, SuccessRepository successRepository, QuizMapper mapper, SuccessMapper successMapper) {
        this.quizRepository = repository;
        this.successRepository = successRepository;
        this.quizMapper = mapper;
        this.successMapper = successMapper;
    }

    @Override
    public Page<QuizDto> findAll(Pageable pageable) {
        return quizRepository.findAll(
                PageRequest.of(
                        pageable.getPageNumber(),
                        10
                )).map(quizMapper::toDto);
    }

    @Override
    public Page<SuccessDto> getCompletion(Pageable pageable, User user) {
        return successRepository.findByUsername(
                user.getUsername(),
                PageRequest.of(
                        pageable.getPageNumber(),
                        10,
                        Sort.by("completedAt").descending()
                )).map(successMapper::toDto);
    }

    @Override
    public Quiz getById(long id) throws QuizNotFoundException {
        return quizRepository.findById(id).orElseThrow(QuizNotFoundException::new);
    }

    @Override
    public Result answer(long id, AnswerDto answer, User user) throws QuizNotFoundException {
        Quiz quiz = getById(id);
        boolean isCorrect;

        if (quiz.getAnswer() == null) {
            isCorrect = answer.answer().length == 0;
        } else {
            isCorrect = Arrays.equals(
                    Arrays.stream(answer.answer()).sorted().toArray(),
                    Arrays.stream(quiz.getAnswer()).sorted().toArray());
        }

        if (isCorrect) {
            Success success = new Success(id, user);
            successRepository.save(success);
        }

        return new Result(isCorrect);
    }

    @Override
    public Quiz create(QuizDto quizDto, User user) {
        return quizRepository.save(quizMapper.toEntity(quizDto, user));
    }

    @Override
    public void delete(long id, String username) {
        quizRepository.findById(id)
                .ifPresentOrElse(quiz -> executeIfOwnerOrThrow(quiz, quizRepository::delete, username),
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

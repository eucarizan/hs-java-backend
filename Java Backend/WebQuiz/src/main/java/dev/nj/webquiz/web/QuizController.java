package dev.nj.webquiz.web;

import dev.nj.webquiz.entities.Result;
import dev.nj.webquiz.entities.User;
import dev.nj.webquiz.exceptions.NotOwnerException;
import dev.nj.webquiz.exceptions.QuizNotFoundException;
import dev.nj.webquiz.services.QuizService;
import dev.nj.webquiz.web.dto.AnswerDto;
import dev.nj.webquiz.web.dto.QuizDto;
import dev.nj.webquiz.web.mapper.QuizMapper;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    private final QuizService quizService;
    private final QuizMapper mapper;

    @Autowired
    public QuizController(QuizService quizService, QuizMapper mapper) {
        this.quizService = quizService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<Page<QuizDto>> getAllQuiz(Pageable pageable) {
        return ResponseEntity.ok(quizService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizDto> getQuiz(@PathVariable("id") Long quizId) {
        return ResponseEntity.ok(mapper.toDto(quizService.getById(quizId)));
    }

    @PostMapping
    public ResponseEntity<QuizDto> createQuiz(@RequestBody @Valid QuizDto quizDto,
                                              @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(mapper.toDto(quizService.create(quizDto, user)));
    }

    @PostMapping("/{id}/solve")
    public ResponseEntity<Result> answerQuiz(@PathVariable("id") Long quiz,
                                             @RequestBody AnswerDto answer) {
        return ResponseEntity.ok(quizService.answer(quiz, answer));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable("id") long id,
                                           @AuthenticationPrincipal User user) {
        quizService.delete(id, user.getUsername());
        return ResponseEntity.noContent().build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handeValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
                    String fieldName = ((FieldError) error).getField();
                    String errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                }
        );
        return errors;
    }

    @ExceptionHandler(QuizNotFoundException.class)
    ResponseEntity<Object> handleQuizNotFoundException(QuizNotFoundException ex) {
        return new ResponseEntity<>(Map.of("error", "Quiz not found"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotOwnerException.class)
    ResponseEntity<Object> handleNotOwnerException(NotOwnerException ex) {
        return new ResponseEntity<>(Map.of("error", "Only the owner can delete this quiz"), HttpStatus.FORBIDDEN);
    }
}

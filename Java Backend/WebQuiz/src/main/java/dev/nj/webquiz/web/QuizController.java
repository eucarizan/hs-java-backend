package dev.nj.webquiz.web;

import dev.nj.webquiz.entities.Result;
import dev.nj.webquiz.entities.User;
import dev.nj.webquiz.services.QuizService;
import dev.nj.webquiz.web.dto.AnswerDto;
import dev.nj.webquiz.web.dto.QuizDto;
import dev.nj.webquiz.web.mapper.QuizMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
    public ResponseEntity<List<QuizDto>> getQuizzes() {
        return ResponseEntity.ok(
                StreamSupport.stream(quizService.getQuizzes().spliterator(), false)
                        .map(mapper::toDto)
                        .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizDto> getQuiz(@PathVariable("id") Long quizId) {
        return ResponseEntity.ok(mapper.toDto(quizService.getQuiz(quizId)));
    }

    @PostMapping
    public ResponseEntity<QuizDto> createQuiz(@RequestBody @Valid QuizDto quizDto,
                                              @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(mapper.toDto(quizService.createQuiz(quizDto, user)));
    }

    @PostMapping("/{id}/solve")
    public ResponseEntity<Result> answerQuiz(@PathVariable("id") Long quiz,
                                             @RequestBody AnswerDto answer) {
        return ResponseEntity.ok(quizService.answerQuiz(quiz, answer));
    }
}

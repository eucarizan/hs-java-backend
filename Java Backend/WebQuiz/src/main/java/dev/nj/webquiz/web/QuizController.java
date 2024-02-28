package dev.nj.webquiz.web;

import dev.nj.webquiz.entities.Quiz;
import dev.nj.webquiz.entities.Result;
import dev.nj.webquiz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class QuizController {

    QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/quiz")
    public ResponseEntity<Quiz> getQuiz() {
        return ResponseEntity.ok(quizService.getQuiz());
    }

    @PostMapping("/quiz")
    public ResponseEntity<Result> answerQuiz(@RequestParam int answer) {
        return ResponseEntity.ok(quizService.answerQuiz(answer));
    }
}

package dev.nj.webquiz.web.mapper;

import dev.nj.webquiz.entities.Quiz;
import dev.nj.webquiz.entities.User;
import dev.nj.webquiz.web.dto.QuizDto;
import org.springframework.stereotype.Component;

@Component
public class QuizMapper {
    public QuizDto toDto(Quiz quiz) {
        return new QuizDto(
                quiz.getId(),
                quiz.getTitle(),
                quiz.getText(),
                quiz.getOptions(),
                quiz.getAnswer());
    }

    public Quiz toEntity(QuizDto quizDto, User user) {
        return new Quiz(
                quizDto.title(),
                quizDto.text(),
                quizDto.options(),
                quizDto.answer(),
                user);
    }
}

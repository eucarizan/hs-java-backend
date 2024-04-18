package dev.nj.webquiz.web.mapper;

import dev.nj.webquiz.entities.Success;
import dev.nj.webquiz.web.dto.SuccessDto;
import org.springframework.stereotype.Component;

@Component
public class SuccessMapper {
    public SuccessDto toDto(Success success) {
        return new SuccessDto(
                success.getQuizId(),
                success.getCompletedAt());
    }
}

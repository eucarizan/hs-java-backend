package dev.nj.webquiz.web.dto;

import java.time.LocalDateTime;

public record SuccessDto(
        long id,
        LocalDateTime completedAt
) {
}

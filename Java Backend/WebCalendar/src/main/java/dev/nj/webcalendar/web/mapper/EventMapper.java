package dev.nj.webcalendar.web.mapper;


import dev.nj.webcalendar.entities.CalendarEvent;
import dev.nj.webcalendar.web.dto.EventDto;
import dev.nj.webcalendar.web.dto.SavedEventDto;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {
    public SavedEventDto toDto(CalendarEvent event, String message) {
        return new SavedEventDto(
                message,
                event.name(),
                event.localDate()
        );
    }

    public CalendarEvent toEntity(int id, EventDto dto) {
        return new CalendarEvent(
                id,
                dto.event(),
                dto.date()
        );
    }
}

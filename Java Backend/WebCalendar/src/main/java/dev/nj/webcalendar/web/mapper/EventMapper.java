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
                event.getEvent(),
                event.getDate()
        );
    }

    public CalendarEvent toEntity(EventDto dto) {
        return new CalendarEvent(
                -1,
                dto.event(),
                dto.date()
        );
    }
}

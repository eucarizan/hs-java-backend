package dev.nj.webcalendar.service;

import dev.nj.webcalendar.entities.CalendarEvent;
import dev.nj.webcalendar.web.dto.EventDto;
import dev.nj.webcalendar.web.dto.SavedEventDto;

import java.time.LocalDate;
import java.util.List;

public interface EventsService {
    List<CalendarEvent> getAllCalendarEvent();

    List<CalendarEvent> getAllEventsToday(LocalDate date);

    SavedEventDto save(EventDto eventDto);
}

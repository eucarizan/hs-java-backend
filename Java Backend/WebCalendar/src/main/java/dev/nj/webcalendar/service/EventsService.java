package dev.nj.webcalendar.service;

import dev.nj.webcalendar.entities.CalendarEvent;
import dev.nj.webcalendar.web.dto.EventDto;
import dev.nj.webcalendar.web.dto.SavedEventDto;

import java.util.List;

public interface EventsService {
    List<CalendarEvent> getAllCalendarEvent();

    SavedEventDto save(EventDto eventDto);
}

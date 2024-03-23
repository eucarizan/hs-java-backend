package dev.nj.webcalendar.service.impl;

import dev.nj.webcalendar.entities.CalendarEvent;
import dev.nj.webcalendar.service.EventsService;
import dev.nj.webcalendar.web.dto.EventDto;
import dev.nj.webcalendar.web.dto.SavedEventDto;
import dev.nj.webcalendar.web.mapper.EventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventsServiceImpl implements EventsService {

    List<CalendarEvent> events;
    int idx;

    @Autowired
    EventMapper mapper;

    public EventsServiceImpl() {
        this.events = new ArrayList<>();
        idx = 0;
    }

    @Override
    public List<CalendarEvent> getAllCalendarEvent() {
        return events;
    }

    @Override
    public SavedEventDto save(EventDto dto) {
        CalendarEvent event = mapper.toEntity(idx++, dto);
        events.add(event);
        return mapper.toDto(event, "The event has been added!");
    }
}

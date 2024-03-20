package dev.nj.webcalendar.service.impl;

import dev.nj.webcalendar.entities.CalendarEvent;
import dev.nj.webcalendar.service.EventsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventsServiceImpl implements EventsService {

    List<CalendarEvent> events;

    public EventsServiceImpl() {
        this.events = new ArrayList<>();
    }

    @Override
    public List<CalendarEvent> getAllCalendarEvent() {
        return events;
    }
}

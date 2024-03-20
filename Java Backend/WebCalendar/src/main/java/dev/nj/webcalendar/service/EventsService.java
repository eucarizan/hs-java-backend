package dev.nj.webcalendar.service;

import dev.nj.webcalendar.entities.CalendarEvent;

import java.util.List;

public interface EventsService {
    List<CalendarEvent> getAllCalendarEvent();
}

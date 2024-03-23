package dev.nj.webcalendar.service.impl;

import dev.nj.webcalendar.entities.CalendarEvent;
import dev.nj.webcalendar.repositories.EventRepository;
import dev.nj.webcalendar.service.EventsService;
import dev.nj.webcalendar.web.dto.EventDto;
import dev.nj.webcalendar.web.dto.SavedEventDto;
import dev.nj.webcalendar.web.mapper.EventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventsServiceImpl implements EventsService {

    @Autowired
    EventMapper mapper;
    @Autowired
    EventRepository repo;

    @Override
    public List<CalendarEvent> getAllCalendarEvent() {
        return repo.findAll();
    }

    @Override
    public List<CalendarEvent> getAllEventsToday(LocalDate date) {
        return repo.findAllByDate(date);
    }

    @Override
    public SavedEventDto save(EventDto dto) {
        CalendarEvent event = mapper.toEntity(dto);
        repo.save(event);
        return mapper.toDto(event, "The event has been added!");
    }
}

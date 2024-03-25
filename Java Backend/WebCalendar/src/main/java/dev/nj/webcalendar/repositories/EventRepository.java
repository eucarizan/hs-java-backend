package dev.nj.webcalendar.repositories;

import dev.nj.webcalendar.entities.CalendarEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<CalendarEvent, Long> {
    List<CalendarEvent> findAllByDate(LocalDate date);
    List<CalendarEvent> findAllByDateBetween(LocalDate startDate, LocalDate endDate);
}

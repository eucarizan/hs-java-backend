package dev.nj.webcalendar.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class CalendarEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column
    String event;
    @Column
    LocalDate date;

    public CalendarEvent() {
    }

    public CalendarEvent(int id, String event, LocalDate date) {
        this.id = id;
        this.event = event;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getEvent() {
        return event;
    }

    public LocalDate getDate() {
        return date;
    }
}

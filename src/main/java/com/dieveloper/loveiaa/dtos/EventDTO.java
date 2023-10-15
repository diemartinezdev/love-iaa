package com.dieveloper.loveiaa.dtos;

import com.dieveloper.loveiaa.models.Event;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventDTO {
    private Long id;
    private LocalDate date;
    private LocalTime hour;
    private String activityName;
    private String institutionName;

    public EventDTO(Event event) {
        this.id = event.getId();
        this.date = event.getDate();
        this.hour = event.getHour();
        this.activityName = event.getActivity().getName();
        this.institutionName = event.getInstitution().getName();
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getHour() {
        return hour;
    }

    public String getActivityName() {
        return activityName;
    }

    public String getInstitutionName() {
        return institutionName;
    }
}

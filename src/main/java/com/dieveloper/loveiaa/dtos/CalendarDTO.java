package com.dieveloper.loveiaa.dtos;

import com.dieveloper.loveiaa.models.Calendar;

import java.time.LocalDate;
import java.time.LocalTime;

public class CalendarDTO {
    private Long id;
    private LocalDate date;
    private LocalTime hour;
    private String activityName;
    private String institutionName;

    public CalendarDTO(Calendar calendar) {
        this.id = calendar.getId();
        this.date = calendar.getDate();
        this.hour = calendar.getHour();
        this.activityName = calendar.getActivity().getName();
        this.institutionName = calendar.getInstitution().getName();
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

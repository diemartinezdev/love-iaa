package com.dieveloper.loveiaa.dtos;

import com.dieveloper.loveiaa.models.Calendar;

import java.time.LocalDate;
import java.time.LocalTime;

public class CalendarDTO {
    private Long id;
    private LocalDate date;
    private LocalTime hour;
    private Long activityId;
    private Long institutionId;

    public CalendarDTO(Calendar calendar) {
        this.id = calendar.getId();
        this.date = calendar.getDate();
        this.hour = calendar.getHour();
        this.activityId = calendar.getActivity().getId();
        this.institutionId = calendar.getInstitution().getId();
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

    public Long getActivityId() {
        return activityId;
    }

    public Long getInstitutionId() {
        return institutionId;
    }
}

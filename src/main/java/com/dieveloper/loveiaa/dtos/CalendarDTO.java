package com.dieveloper.loveiaa.dtos;

import com.dieveloper.loveiaa.models.Calendar;

import java.util.Date;

public class CalendarDTO {
    private Long id;
    private Date date;
    private Date hour;
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

    public Date getDate() {
        return date;
    }

    public Date getHour() {
        return hour;
    }

    public Long getActivityId() {
        return activityId;
    }

    public Long getInstitutionId() {
        return institutionId;
    }
}

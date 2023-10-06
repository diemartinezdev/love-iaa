package com.dieveloper.loveiaa.models;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private LocalDate date;
    private LocalTime hour;

    @ManyToOne
    @JoinColumn(name = "activity_name")
    private Activity activity;

    @ManyToOne
    @JoinColumn(name = "institution_name")
    private Institution institution;

    @ManyToOne
    @JoinColumn(name = "professional_id")
    private Professional professional;

    public Calendar() { }

    public Calendar(LocalDate date, LocalTime hour, Activity activity, Institution institution, Professional professional) {
        this.date = date;
        this.hour = hour;
        this.activity = activity;
        this.institution = institution;
        this.professional = professional;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }
}

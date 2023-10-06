package com.dieveloper.loveiaa.dtos;

import com.dieveloper.loveiaa.models.Activity;
import com.dieveloper.loveiaa.models.Professional;

import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

public class ProfessionalDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Set<InstitutionDTO> institutions;
    private Set<ActivityDTO> activities;

    private Set<CalendarDTO> calendars;

    public ProfessionalDTO() {
    }

    public ProfessionalDTO(Professional professional) {
        this.id = professional.getId();
        this.firstName = professional.getFirstName();
        this.lastName = professional.getLastName();
        this.email = professional.getEmail();
        this.password = professional.getPassword();
        this.institutions = professional
                .getInstitutions()
                .stream()
                .map(institution -> new InstitutionDTO(institution))
                .collect(toSet());
        this.activities = professional
                .getActivities()
                .stream()
                .map(activity -> new ActivityDTO(activity))
                .collect(toSet());
        this.calendars = professional
                .getCalendars()
                .stream().map(calendar -> new CalendarDTO(calendar))
                .collect(toSet());
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Set<InstitutionDTO> getInstitutions() {
        return institutions;
    }

    public Set<ActivityDTO> getActivities() {
        return activities;
    }

    public Set<CalendarDTO> getCalendars() {
        return calendars;
    }
}

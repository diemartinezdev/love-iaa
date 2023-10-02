package com.dieveloper.loveiaa.controllers;

import com.dieveloper.loveiaa.dtos.CalendarDTO;
import com.dieveloper.loveiaa.repositories.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CalendarController {
    @Autowired
    private CalendarRepository calendarRepository;

    @GetMapping("/calendars")
    private List<CalendarDTO> getCalendars() {
        return calendarRepository.findAll().stream().map(calendar -> new CalendarDTO(calendar)).collect(Collectors.toList());
    }

    @GetMapping("/calendars/{id}")
    private CalendarDTO getCalendars(@PathVariable Long id) {
        return new CalendarDTO(calendarRepository.findById(id).orElse(null));
    }
}

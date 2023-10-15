package com.dieveloper.loveiaa.controllers;

import com.dieveloper.loveiaa.dtos.EventDTO;
import com.dieveloper.loveiaa.repositories.EventRepository;
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
    private EventRepository eventRepository;

    @GetMapping("/calendars")
    private List<EventDTO> getCalendars() {
        return eventRepository.findAll().stream().map(calendar -> new EventDTO(calendar)).collect(Collectors.toList());
    }

    @GetMapping("/calendars/{id}")
    private EventDTO getCalendars(@PathVariable Long id) {
        return new EventDTO(eventRepository.findById(id).orElse(null));
    }
}

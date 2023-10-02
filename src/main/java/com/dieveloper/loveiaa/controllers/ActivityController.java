package com.dieveloper.loveiaa.controllers;

import com.dieveloper.loveiaa.dtos.ActivityDTO;
import com.dieveloper.loveiaa.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ActivityController {
    @Autowired
    private ActivityRepository activityRepository;

    @GetMapping("/activities")
    private List<ActivityDTO> getActivities() {
        return activityRepository.findAll().stream().map(activity -> new ActivityDTO(activity)).collect(Collectors.toList());
    }

    @GetMapping("/activities/{id}")
    private ActivityDTO getActivities(@PathVariable Long id) {
        return new ActivityDTO(activityRepository.findById(id).orElse(null));
    }
}

package com.dieveloper.loveiaa.controllers;

import com.dieveloper.loveiaa.dtos.ProfessionalDTO;
import com.dieveloper.loveiaa.repositories.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api")
public class ProfessionalController {
    @Autowired
    private ProfessionalRepository professionalRepository;

    @GetMapping("/professionals")
    private List<ProfessionalDTO> getProfessionals() {
        return professionalRepository.findAll().stream().map(professional->new ProfessionalDTO(professional)).collect(toList());
    }

    @GetMapping("/professionals/{id}")
    private ProfessionalDTO getProfessionals(@PathVariable Long id) {
        return new ProfessionalDTO(professionalRepository.findById(id).orElse(null));
    }
}

package com.dieveloper.loveiaa.controllers;

import com.dieveloper.loveiaa.dtos.InstitutionDTO;
import com.dieveloper.loveiaa.repositories.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class InstitutionController {
    @Autowired
    private InstitutionRepository institutionRepository;

    @GetMapping("/institutions")
    private List<InstitutionDTO> getInstitutions() {
        return institutionRepository.findAll().stream().map(institution -> new InstitutionDTO(institution)).collect(Collectors.toList());
    }

    @GetMapping("/institutions/{id}")
    private InstitutionDTO getInstitutions(@PathVariable Long id) {
        return new InstitutionDTO(institutionRepository.findById(id).orElse(null));
    }
}

package com.dieveloper.loveiaa.controllers;

import com.dieveloper.loveiaa.dtos.InstitutionDTO;
import com.dieveloper.loveiaa.models.Institution;
import com.dieveloper.loveiaa.models.Professional;
import com.dieveloper.loveiaa.repositories.InstitutionRepository;
import com.dieveloper.loveiaa.repositories.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class InstitutionController {
    @Autowired
    private InstitutionRepository institutionRepository;

    @Autowired
    private ProfessionalRepository professionalRepository;

    @GetMapping("/institutions")
    private List<InstitutionDTO> getInstitutions() {
        return institutionRepository.findAll().stream().map(institution -> new InstitutionDTO(institution)).collect(Collectors.toList());
    }

    @GetMapping("/institutions/{id}")
    private InstitutionDTO getInstitutions(@PathVariable Long id) {
        return new InstitutionDTO(institutionRepository.findById(id).orElse(null));
    }

    @PostMapping("/professionals/current/institutions")
        public ResponseEntity<Object> create(
                @RequestParam String name, @RequestParam String street, @RequestParam Integer number, @RequestParam String city, @RequestParam String province, @RequestParam String country, @RequestParam String mail, Authentication authentication
    ) {
        Professional newProfessional = professionalRepository.findByEmail(authentication.getName());
        Institution institution = new Institution(name, street, number, city, province, country, mail, newProfessional);
        institutionRepository.save(institution);
        return new ResponseEntity<>("Institution added", HttpStatus.CREATED);
    }
}

package com.dieveloper.loveiaa.controllers;

import com.dieveloper.loveiaa.dtos.ProfessionalDTO;
import com.dieveloper.loveiaa.models.Professional;
import com.dieveloper.loveiaa.repositories.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api")
public class ProfessionalController {
    @Autowired
    private PasswordEncoder passwordEncoder;
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

    @PostMapping("/professionals")
    public ResponseEntity<Object> register(
            @RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String password
    ) {
        if (firstName.isEmpty()) {
            return new ResponseEntity<>("Please complete the first name", HttpStatus.FORBIDDEN);
        }
        if (lastName.isEmpty()) {
            return new ResponseEntity<>("Please complete the last name", HttpStatus.FORBIDDEN);
        }
        if (email.isEmpty()) {
            return new ResponseEntity<>("Please complete the email", HttpStatus.FORBIDDEN);
        }
        if (password.isEmpty()) {
            return new ResponseEntity<>("Please complete the password", HttpStatus.FORBIDDEN);
        }
        if (professionalRepository.findByEmail(email) != null) {
            return new ResponseEntity<>("Email already in use", HttpStatus.FORBIDDEN);
        }
        Professional newProfessional = new Professional(firstName, lastName, email, passwordEncoder.encode(password));
        professionalRepository.save(newProfessional);
        return new ResponseEntity<>("Account created :D", HttpStatus.CREATED);
    }

    @GetMapping("/professionals/current")
    public ProfessionalDTO getCurrent (Authentication authentication) {
        return new ProfessionalDTO(professionalRepository.findByEmail(authentication.getName()));
    }
}

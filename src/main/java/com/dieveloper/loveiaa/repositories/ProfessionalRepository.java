package com.dieveloper.loveiaa.repositories;

import com.dieveloper.loveiaa.models.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProfessionalRepository extends JpaRepository<Professional, Long> {
}

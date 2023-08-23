package com.dieveloper.loveiaa.repositories;

import com.dieveloper.loveiaa.models.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface InstitutionRepository extends JpaRepository<Institution, Long> {
}

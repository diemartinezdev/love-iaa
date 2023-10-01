package com.dieveloper.loveiaa.repositories;

import com.dieveloper.loveiaa.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ActivityRepository extends JpaRepository<Activity, Long> {
}

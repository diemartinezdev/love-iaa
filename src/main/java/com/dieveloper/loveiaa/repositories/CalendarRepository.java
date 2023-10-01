package com.dieveloper.loveiaa.repositories;

import com.dieveloper.loveiaa.models.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CalendarRepository extends JpaRepository<Calendar, Long> {
}

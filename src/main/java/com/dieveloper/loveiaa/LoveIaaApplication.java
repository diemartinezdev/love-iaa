package com.dieveloper.loveiaa;

import com.dieveloper.loveiaa.models.Activity;
import com.dieveloper.loveiaa.models.Calendar;
import com.dieveloper.loveiaa.models.Institution;
import com.dieveloper.loveiaa.models.Professional;
import com.dieveloper.loveiaa.repositories.ActivityRepository;
import com.dieveloper.loveiaa.repositories.CalendarRepository;
import com.dieveloper.loveiaa.repositories.InstitutionRepository;
import com.dieveloper.loveiaa.repositories.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class LoveIaaApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(LoveIaaApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ProfessionalRepository professionalRepository, InstitutionRepository institutionRepository, ActivityRepository activityRepository, CalendarRepository calendarRepository) {
		return (args) -> {
			Professional user0 = new Professional("Pepe","Pepitez","pepe@gmail.com", passwordEncoder.encode("pepita"));
			professionalRepository.save(user0);
			Institution inst0 = new Institution("Pera Terres","Lepant",11,"Barcelona","Barcelona","España","pera@terres.com",user0);
			institutionRepository.save(inst0);

			Professional user1 = new Professional("Alesia", "Filippo", "alex@gmail.com",  passwordEncoder.encode("pupi123"));
			professionalRepository.save(user1);
			Institution inst1 = new Institution("Raices","Aranguren",4518,"Floresta","CABA","Argentina","raices@gmail.com",user1);
			institutionRepository.save(inst1);
			Institution inst2 = new Institution("Tierra de encuentro","Miramar golf club",2662,"Pilar","Buenos Aires","Argentina","tierra@deencuentro.com",user1);
			institutionRepository.save(inst2);

			Activity acti1 = new Activity("Equilibrio","Propiocepción","asdfasdf","Pelota a la mitad","Se sube a la pelota",4,9,25,user1);
			activityRepository.save(acti1);

			Calendar event1 = new Calendar(LocalDate.of(2023,2,22),LocalTime.of(22,03),acti1,inst2,user1);
			calendarRepository.save(event1);
		};
	}
}

package com.dieveloper.loveiaa;

import com.dieveloper.loveiaa.models.Activity;
import com.dieveloper.loveiaa.models.Calendar;
import com.dieveloper.loveiaa.models.Institution;
import com.dieveloper.loveiaa.models.Professional;
import com.dieveloper.loveiaa.repositories.ActivityRepository;
import com.dieveloper.loveiaa.repositories.CalendarRepository;
import com.dieveloper.loveiaa.repositories.InstitutionRepository;
import com.dieveloper.loveiaa.repositories.ProfessionalRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class LoveIaaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoveIaaApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ProfessionalRepository professionalRepository, InstitutionRepository institutionRepository, ActivityRepository activityRepository, CalendarRepository calendarRepository) {
		return (args) -> {
			Professional user0 = new Professional("Pepe","Pepitez","pepe@gmail.com","pepita");
			professionalRepository.save(user0);
			Institution inst0 = new Institution("Pera Terres","Lepant",11,"Barcelona","Barcelona","España","pera@terres.com",user0);
			institutionRepository.save(inst0);

			Professional user1 = new Professional("Alesia", "Filippo", "alex@gmail.com", "pupi123");
			professionalRepository.save(user1);
			Institution inst1 = new Institution("Raices","Aranguren",4518,"Floresta","CABA","Argentina","raices@gmail.com",user1);
			institutionRepository.save(inst1);
			Institution inst2 = new Institution("Tierra de encuentro","Miramar golf club",2662,"Pilar","Buenos Aires","Argentina","tierra@deencuentro.com",user1);
			institutionRepository.save(inst2);

			Activity acti1 = new Activity("Equilibrio","Propiocepción","asdfasdf","Pelota a la mitad","Se sube a la pelota",4,9,25,user1);
			activityRepository.save(acti1);

		};
	}
}

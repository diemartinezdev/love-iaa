package com.dieveloper.loveiaa;

import com.dieveloper.loveiaa.models.Institution;
import com.dieveloper.loveiaa.models.Professional;
import com.dieveloper.loveiaa.repositories.InstitutionRepository;
import com.dieveloper.loveiaa.repositories.ProfessionalRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LoveIaaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoveIaaApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ProfessionalRepository professionalRepository, InstitutionRepository institutionRepository) {
		return (args) -> {
			Professional user0 = new Professional("Pepe","Pepitez","pepe@gmail.com","pepita");
			professionalRepository.save(user0);

			/*
			Institution inst0 = new Institution("Pera Terres","Lepant, 11, Barcelona, Barcelona, España","pera@terres.com");
			institutionRepository.save(inst0);
			user0.addInstitution(inst0);
*/
		};
	}
}

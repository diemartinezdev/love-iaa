package com.dieveloper.loveiaa;

import com.dieveloper.loveiaa.models.Professional;
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
	public CommandLineRunner initData(ProfessionalRepository professionalRepository) {
		return (args) -> {
			Professional user0 = new Professional("Pepe","Pepitez","pepe@gmail.com","pepita");
			professionalRepository.save(user0);
		};
	}
}

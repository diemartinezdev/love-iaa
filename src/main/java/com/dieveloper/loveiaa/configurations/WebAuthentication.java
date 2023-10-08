package com.dieveloper.loveiaa.configurations;

import com.dieveloper.loveiaa.models.Professional;
import com.dieveloper.loveiaa.repositories.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration

public class WebAuthentication extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    ProfessionalRepository professionalRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(email-> {
            Professional professional = professionalRepository.findByEmail(email);
            if (professional != null) {
                if (professional.getEmail().equals("admin@loveiaa.com")) {
                    return new User(professional.getEmail(), professional.getPassword(),
                            AuthorityUtils.createAuthorityList("ADMIN"));
                } else {
                    return new User(professional.getEmail(), professional.getPassword(),
                            AuthorityUtils.createAuthorityList("USER"));
                }
            } else {
                    throw new UsernameNotFoundException("Unknown user: " + email);
            }
        });
    }
}


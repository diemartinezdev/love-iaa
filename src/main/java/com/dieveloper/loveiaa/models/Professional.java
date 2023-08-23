package com.dieveloper.loveiaa.models;

import com.dieveloper.loveiaa.repositories.InstitutionRepository;
import org.aspectj.lang.reflect.InitializerSignature;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Professional {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @OneToMany(mappedBy="prof", fetch=FetchType.EAGER)
    Set<Institution> institutions = new HashSet<>();

    public Professional() { }
    public Professional(String first, String last, String email, String password) {
        this.firstName = first;
        this.lastName = last;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return firstName + " " + lastName;
    }

    public Set<Institution> getInstitutions() {
        return institutions;
    }

    public void addInstitution(Institution institution) {
        institution.setProf(this);
        institutions.add(institution);
    }
}

package com.dieveloper.loveiaa.dtos;

import com.dieveloper.loveiaa.models.Institution;

public class InstitutionDTO {
    private Long id;
    private String name;
    private Institution.Address address;
    private String contact;

    public InstitutionDTO() { }
    public InstitutionDTO(Institution institution) {
        this.id = institution.getId();
        this.name = institution.getName();
        this.address = institution.getAddress();
        this.contact = institution.getContact();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Institution.Address getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }
}

package com.dieveloper.loveiaa.dtos;

import com.dieveloper.loveiaa.models.Institution;

public class InstitutionDTO {
    private Long id;
    private String name;
    private String street;
    private Integer number;
    private String city;
    private String province;
    private String country;
    private String email;

    public InstitutionDTO() { }
    public InstitutionDTO(Institution institution) {
        this.id = institution.getId();
        this.name = institution.getName();
        this.street = institution.getStreet();
        this.number = institution.getNumber();
        this.city = institution.getCity();
        this.province = institution.getProvince();
        this.country = institution.getCountry();
        this.email = institution.getEmail();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public Integer getNumber() {
        return number;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getCountry() {
        return country;
    }

    public String getEmail() {
        return email;
    }
}

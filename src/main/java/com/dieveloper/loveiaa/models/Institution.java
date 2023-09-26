package com.dieveloper.loveiaa.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String name;
    private Address address;
    private String contact;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "prof_id")
    private Professional professional;

    public Institution() {
    }

    public Institution(String name, Address address, String contact) {
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Professional getProfessionals() {
        return professional;
    }

    public void setProfessionals(Professional professionals) {
        this.professional = professionals;
    }

    public static class Address {
        private String street;
        private Integer number;
        private String city;
        private String province;
        private String country;

        public Address(String street, Integer number, String city, String province, String country) {
            this.street = street;
            this.number = number;
            this.city = city;
            this.province = province;
            this.country = country;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        @Override
        public String toString() {
            return "Address: " + street + ", " + number + ", " + city + ", " + province + ", " + country;
        }
    }
}

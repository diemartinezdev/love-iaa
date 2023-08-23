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
    private String address;
    private String contact;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="prof_id")
    private Professional prof;

    public Institution() { }

    public Institution(String name, String address, String contact) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Professional getProf() {
        return prof;
    }

    public void setProf(Professional prof) {
        this.prof = prof;
    }
}

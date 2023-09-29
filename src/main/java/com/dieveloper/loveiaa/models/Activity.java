package com.dieveloper.loveiaa.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String name;
    private String type;
    private String description;
    private String materials;
    private String dynamic;
    private Integer patients;
    private Integer valoration;
    private Integer duration;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "prof_id")
    private Professional professional;

    /*
    Establecer relacion muchos a muchos con institucion
     */
    public Activity() { }
    public Activity(String name, String type, String description, String materials, String dynamic, Integer patients, Integer valoration, Integer duration, Professional professional) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.materials = materials;
        this.dynamic = dynamic;
        this.patients = patients;
        this.valoration = valoration;
        this.duration = duration;
        this.professional = professional;
    }
}

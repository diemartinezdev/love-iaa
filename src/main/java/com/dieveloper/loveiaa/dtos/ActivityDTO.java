package com.dieveloper.loveiaa.dtos;

import com.dieveloper.loveiaa.models.Activity;
import com.dieveloper.loveiaa.models.Calendar;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ActivityDTO {
    private Long id;
    private String name;
    private String type;
    private String description;
    private String materials;
    private String dynamic;
    private Integer patients;
    private Integer valoration;
    private Integer duration;

    public ActivityDTO() { }
    public ActivityDTO(Activity activity) {
        this.id = activity.getId();
        this.name = activity.getName();
        this.type = activity.getType();
        this.description = activity.getDescription();
        this.materials = activity.getMaterials();
        this.dynamic = activity.getDynamic();
        this.patients = activity.getPatients();
        this.valoration = activity.getValoration();
        this.duration = activity.getDuration();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getMaterials() {
        return materials;
    }

    public String getDynamic() {
        return dynamic;
    }

    public Integer getPatients() {
        return patients;
    }

    public Integer getValoration() {
        return valoration;
    }

    public Integer getDuration() {
        return duration;
    }

}

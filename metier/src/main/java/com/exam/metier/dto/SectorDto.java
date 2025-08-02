package com.exam.metier.dto;

import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "sector")
@XmlAccessorType(XmlAccessType.FIELD)
public class SectorDto implements Serializable {


    @XmlElement(required = true)
    private int id;

    @XmlElement(required = true)
    private String name;

    @XmlElement(name = "classes")
    private List<ClasseDto> classes;

    public SectorDto() {
        	super();
    }

    public SectorDto(int id, String name) {
        	super();
        this.id = id;
        this.name = name;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ClasseDto> getClasses() {
        return classes;
    }

    public void setClasses(List<ClasseDto> classes) {
        this.classes = classes;
    }
}

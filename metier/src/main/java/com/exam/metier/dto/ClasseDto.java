package com.exam.metier.dto;

import java.io.Serializable;
import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "classe")
@XmlAccessorType(XmlAccessType.FIELD)
public class ClasseDto implements Serializable {

    @XmlElement(required = true)
    private int id;

    @XmlElement(required = true)
    private String className;

    @XmlElement(required = false)
    private String description;

    @XmlElement(name = "sectorId", required = true)
    private int sectorId;

    public ClasseDto() {
        super();
    }

    public ClasseDto(int id, String className, String description, int sectorId) {
        this.id = id;
        this.className = className;
        this.description = description;
        this.sectorId = sectorId;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSectorId() {
        return sectorId;
    }

    public void setSectorId(int sectorId) {
        this.sectorId = sectorId;
    }
}

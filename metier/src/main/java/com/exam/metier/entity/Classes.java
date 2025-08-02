package com.exam.metier.entity;

import javax.persistence.*;

@Entity
@Table(name = "classes")
public class Classes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "class_name", nullable = false)
    private String className;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "sector_id", nullable = false)
    private Sectors sector;





    // Default constructor
    public Classes() {
    }

    // Parameterized constructor
    public Classes(int id, String className, String description, Sectors sector) {
        this.id = id;
        this.className = className;
        this.description = description;
        this.sector = sector;
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

    public Sectors getSector() {
        return sector;
    }

    public void setSector(Sectors sector) {
        this.sector = sector;
    }
}

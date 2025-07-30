package com.exam.metier.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Sectors")
public class Sectors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "sector", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Classes> classes;

    // Default constructor
    public Sectors() {
    }

    // Parameterized constructor
    public Sectors(int id, String name, List<Classes> classes) {
        this.id = id;
        this.name = name;
        this.classes = classes;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Classes> getClasses() {
        return classes;
    }

    public void setClasses(List<Classes> classes) {
        this.classes = classes;
    }
}

package com.exam.metier.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sectors")
public class Sectors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "sector", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Classes> classes;

    // Default constructor
    public Sectors() {
    }

    // Parameterized constructor
    public Sectors(Long id, String name, List<Classes> classes) {
        this.id = id;
        this.name = name;
        this.classes = classes;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

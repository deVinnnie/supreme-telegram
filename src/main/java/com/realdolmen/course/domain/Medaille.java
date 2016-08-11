package com.realdolmen.course.domain;

import javax.persistence.*;

@Entity
public class Medaille {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated
    private MedailleType type;

    //@ManyToOne
    //private Country country;

    @Column
    private String sport;

    public Medaille(MedailleType type, String sport) {
        this.type = type;
        this.sport = sport;
    }

    public MedailleType getType() {
        return type;
    }

    public void setType(MedailleType type) {
        this.type = type;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

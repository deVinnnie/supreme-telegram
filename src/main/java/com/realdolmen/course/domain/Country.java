package com.realdolmen.course.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VCLBB37 on 11/08/2016.
 */
@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<Medaille> medals = new ArrayList<>();

    public void addMedal(Medaille medal){
        this.medals.add(medal);
    }

    public int getNumberOfMedals(){
        return this.medals.size();
    }

    public Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Medaille> getMedals() {
        return medals;
    }

    public void setMedals(List<Medaille> medals) {
        this.medals = medals;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

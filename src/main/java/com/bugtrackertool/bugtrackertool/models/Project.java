package com.bugtrackertool.bugtrackertool.models;

import javax.persistence.*;

@Entity
public class Project {

    @Id
    @GeneratedValue
    private int id;

    private String name;

//    @ManyToOne
//    private Ticket ticket;


    public Project(String name) {
        this.name = name;
    }

    public Project() {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
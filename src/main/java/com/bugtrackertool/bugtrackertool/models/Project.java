package com.bugtrackertool.bugtrackertool.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToMany(mappedBy = "project")
    private final List<Ticket> tickets = new ArrayList<>();

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

    public List<Ticket> getTickets() {
        return tickets;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
package com.bugtrackertool.bugtrackertool.models;

import javax.persistence.*;

@Entity
public class Project {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ManyToOne
    private Ticket ticket;


    public Project(String name, Ticket ticket) {
        this.name = name;
        this.ticket = ticket;
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

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ticket=" + ticket +
                '}';
    }
}
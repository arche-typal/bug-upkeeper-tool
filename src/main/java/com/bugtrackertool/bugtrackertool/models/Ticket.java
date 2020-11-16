package com.bugtrackertool.bugtrackertool.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Ticket extends AbstractEntity{

    private String name;

    private String description;

//    @ManyToOne
//    private Project project;

    public Ticket(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Ticket() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

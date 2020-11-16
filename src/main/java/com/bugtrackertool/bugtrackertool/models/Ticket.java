package com.bugtrackertool.bugtrackertool.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Ticket extends AbstractEntity{

    private String name;

    private String description;

    @ManyToOne
    private Project project;

    public Ticket(String name, String description, Project project) {
        this.name = name;
        this.description = description;
        this.project = project;
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", project=" + project +
                '}';
    }
}

package com.bugtrackertool.bugtrackertool.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TestModel {

    @Id
    @GeneratedValue
    private int id;

    private String rawr;

    public TestModel(String rawr) {
        this.rawr = rawr;
    }

    public int getId() {
        return id;
    }

    public String getRawr() {
        return rawr;
    }

    public void setRawr(String rawr) {
        this.rawr = rawr;
    }

    @Override
    public String toString() {
        return rawr;
    }
}

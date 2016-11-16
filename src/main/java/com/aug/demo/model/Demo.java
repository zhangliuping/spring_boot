package com.aug.demo.model;

import java.io.Serializable;

public class Demo implements Serializable {

    private static final long serialVersionUID = 5639305293899443600L;

    private int id;
    private String name;

    public Demo() {
        super();
    }

    public Demo(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Demo [id=" + id + ", name=" + name + "]";
    }

}

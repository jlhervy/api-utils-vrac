package com.jl.hbasetraining;


public class Information {
    private String name;
    private String field;

    public Information(String name, String field) {
        this.name = name;
        this.field = field;
    }

    public String getName() {
        return name;
    }

    public String getField() {
        return field;
    }
}

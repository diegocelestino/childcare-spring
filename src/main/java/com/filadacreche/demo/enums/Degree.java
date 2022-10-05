package com.filadacreche.demo.enums;

public enum Degree {
    NOTE("Note"),
    PROTOCOL("Protocol"),
    WARNING("Warning");


    Degree(String name) {
    }

    private boolean isDegree(){
        String[] degrees = Degree.values().toString().split("");
        return true;
    }

    @Override
    public String toString() {
        return this.name();
    }
}

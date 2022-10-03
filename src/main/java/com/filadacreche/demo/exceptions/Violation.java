package com.filadacreche.demo.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Violation {
    private String name;
    private String message;

    public Violation(String name, String message) {
        this.name = name;
        this.message = message;
    }

}
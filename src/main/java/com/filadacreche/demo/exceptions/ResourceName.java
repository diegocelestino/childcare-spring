package com.filadacreche.demo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResourceName {
    CHILD("Child"),
    SUBGROUP("Subgroup");

    private String name;
}

package com.filadacreche.demo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResourceName {
    CHILD("Child"),
    SUBGROUP("Subgroup"),
    ROOM("Room"),
    GUARDIAN("Guardian"),
    TEACHER("TEACHER");

    private String name;
}

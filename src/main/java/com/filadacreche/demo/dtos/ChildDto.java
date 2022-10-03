package com.filadacreche.demo.dtos;

import lombok.Value;

import java.util.UUID;

@Value
public class ChildDto {

    UUID id;
    String name;
    String birthDate;
    String gender;
    String birthCity;
    String birthState;
    String nacionality;
    String race;
    String cycle;
    String period;

}

package com.filadacreche.demo.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Value
@Getter
@Setter
public class ChildCreateDto {

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

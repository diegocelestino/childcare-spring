package com.filadacreche.demo.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Value
@Getter
@Setter
public class ChildCreateDto {

    String name;
    LocalDate birthDate;
    String registrationNumber;
    LocalDate registrationDate;
    UUID subgroupId;
}

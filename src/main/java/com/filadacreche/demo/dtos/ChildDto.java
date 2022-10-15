package com.filadacreche.demo.dtos;

import com.filadacreche.demo.enums.MovimentMap;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Value
public class ChildDto {

    UUID id;
    String name;
    String birthDate;
    String registrationNumber;
    LocalDate registrationDate;
    String movimentMap;
    String uniformDispatch;
    Boolean uniformDelivered;
    Boolean census;
    SubgroupBasicDto subgroup;
}

package com.filadacreche.demo.dtos;

import lombok.Value;

import java.util.UUID;

@Value
public class GuardianCreateDto {

    String name;
    String cpf;
    String workPeriod;
    UUID childId;

}

package com.filadacreche.demo.dtos;

import lombok.Value;

@Value
public class GuardianDto {
    String id;
    String name;
    String cpf;
    String workPeriod;
    String childrenId;
}

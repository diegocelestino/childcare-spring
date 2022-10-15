package com.filadacreche.demo.dtos;

import lombok.Value;

import java.util.UUID;

@Value
public class GuardianDto {
    UUID id;
    String name;
    String cpf;
}

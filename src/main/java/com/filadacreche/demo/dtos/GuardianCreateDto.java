package com.filadacreche.demo.dtos;

import lombok.Value;

import java.util.UUID;

@Value
public class GuardianCreateDto {
    UUID childId;
    String name;
    String cpf;
}

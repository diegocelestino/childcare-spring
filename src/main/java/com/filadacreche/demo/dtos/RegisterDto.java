package com.filadacreche.demo.dtos;

import lombok.Value;

import java.util.UUID;

@Value
public class RegisterDto {
    UUID childId;
    UUID subgroupId;
}

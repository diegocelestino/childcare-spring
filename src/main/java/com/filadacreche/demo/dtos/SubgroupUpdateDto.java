package com.filadacreche.demo.dtos;

import lombok.Getter;
import lombok.Value;

import java.util.UUID;

@Value
@Getter
public class SubgroupUpdateDto {
    UUID id;
    String cycle;
    String period;
    Integer capacity;
}

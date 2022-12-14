package com.filadacreche.demo.dtos;

import lombok.Getter;
import lombok.Value;

import java.util.UUID;

@Value
@Getter
public class SubgroupCreateDto {
    String cycle;
    String period;
    Integer capacity;
    UUID roomId;
}

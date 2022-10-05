package com.filadacreche.demo.dtos;

import lombok.Getter;
import lombok.Value;

@Value
@Getter
public class SubgroupCreateDto {
    String cycle;
    String period;
    Integer capacity;
}

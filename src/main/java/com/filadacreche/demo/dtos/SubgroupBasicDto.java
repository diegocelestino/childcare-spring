package com.filadacreche.demo.dtos;

import lombok.Value;

import java.util.List;

@Value
public class SubgroupBasicDto {
    String id;
    String cycle;
    String period;
    Integer capacity;
}

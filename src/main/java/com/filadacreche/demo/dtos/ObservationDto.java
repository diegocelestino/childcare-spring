package com.filadacreche.demo.dtos;

import lombok.Value;

import java.util.UUID;

@Value
public class ObservationDto {
    String id;
    String observationType;
    String description;
    ChildBasicDto child;
}

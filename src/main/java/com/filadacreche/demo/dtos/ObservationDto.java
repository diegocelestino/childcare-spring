package com.filadacreche.demo.dtos;

import lombok.Value;

import java.util.UUID;

@Value
public class ObservationDto {
    String id;
    UUID childId;
    String description;
    String kind;
}

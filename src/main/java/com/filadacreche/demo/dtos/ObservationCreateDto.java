package com.filadacreche.demo.dtos;

import lombok.Getter;
import lombok.Value;

import java.util.UUID;

@Value
@Getter
public class ObservationCreateDto {
    UUID childId;
    String observationType;
    String description;

}

package com.filadacreche.demo.dtos;

import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Value
public class ChildBasicDto {

    UUID id;
    String name;

}

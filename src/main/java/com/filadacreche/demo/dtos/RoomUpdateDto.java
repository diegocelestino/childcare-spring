package com.filadacreche.demo.dtos;

import lombok.Value;

import java.util.List;
import java.util.UUID;


@Value
public class RoomUpdateDto {
    UUID id;
    Integer number;
    String name;
    String sedName;
}

package com.filadacreche.demo.dtos;

import lombok.Getter;
import lombok.Value;

@Value
@Getter
public class RoomCreateDto {
    Integer number;
    String name;
    String sedName;
}

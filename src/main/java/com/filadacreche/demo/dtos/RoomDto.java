package com.filadacreche.demo.dtos;

import lombok.Value;

import java.util.List;


@Value
public class RoomDto {
    String id;
    Integer number;
    String name;
    String sedName;
    List<SubgroupBasicDto> subgroups;
}

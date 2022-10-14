package com.filadacreche.demo.dtos;

import lombok.Value;

import java.util.List;

@Value
public class SubgroupDto {
    String id;
    String cycle;
    String period;
    Integer capacity;
    List<TeacherDto> teachers;
    List<ChildDto> children;
    RoomBasicDto room;
}

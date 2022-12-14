package com.filadacreche.demo.dtos;

import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
public class TeacherDto {
    UUID id;
    String name;
    List<SubgroupBasicDto> subgroups;
}

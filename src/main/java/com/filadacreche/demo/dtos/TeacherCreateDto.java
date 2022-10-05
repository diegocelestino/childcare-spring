package com.filadacreche.demo.dtos;

import lombok.Getter;
import lombok.Value;

@Value
@Getter
public class TeacherCreateDto {
    String name;
    String subgroupId;
}

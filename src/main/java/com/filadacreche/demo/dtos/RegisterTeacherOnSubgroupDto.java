package com.filadacreche.demo.dtos;

import lombok.Value;

import java.util.UUID;

@Value
public class RegisterTeacherOnSubgroupDto {
    UUID teacherId;
    UUID subgroupId;
}

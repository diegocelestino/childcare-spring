package com.filadacreche.demo.mappers;

import com.filadacreche.demo.dtos.GuardianDto;
import com.filadacreche.demo.models.Guardian;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GuardianMapper {
    GuardianDto to(Guardian guardian);
}

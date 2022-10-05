package com.filadacreche.demo.mappers;


import com.filadacreche.demo.dtos.GuardianDto;
import com.filadacreche.demo.models.Guardian;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GuardianMapper {
    GuardianDto to(Guardian guardian);
    List<GuardianDto> to(List<Guardian> guardians);
}

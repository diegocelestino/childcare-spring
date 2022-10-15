package com.filadacreche.demo.mappers;


import com.filadacreche.demo.dtos.ObservationDto;
import com.filadacreche.demo.models.Observation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ObservationMapper {
    ObservationDto to(Observation observation);
    List<ObservationDto> to(List<Observation> observations);
}

package com.filadacreche.demo.mappers;


import com.filadacreche.demo.dtos.ChildDto;
import com.filadacreche.demo.models.Child;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChildMapper {
    ChildDto to(Child child);
    List<ChildDto> to(List<Child> children);
}

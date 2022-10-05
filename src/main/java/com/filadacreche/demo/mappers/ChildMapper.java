package com.filadacreche.demo.mappers;


import com.filadacreche.demo.dtos.ChildDto;
import com.filadacreche.demo.models.Child;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChildMapper {
    ChildDto to(Child child);
}

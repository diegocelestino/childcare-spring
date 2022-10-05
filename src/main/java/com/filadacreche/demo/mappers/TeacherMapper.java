package com.filadacreche.demo.mappers;


import com.filadacreche.demo.dtos.TeacherDto;
import com.filadacreche.demo.models.Teacher;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    TeacherDto to(Teacher teacher);
}

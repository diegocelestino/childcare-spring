package com.filadacreche.demo.mappers;


import com.filadacreche.demo.dtos.TeacherDto;
import com.filadacreche.demo.models.Teacher;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    TeacherDto to(Teacher teacher);
    List<TeacherDto> to(List<Teacher> teachers);
}

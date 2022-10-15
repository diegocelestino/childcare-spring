package com.filadacreche.demo.mappers;


import com.filadacreche.demo.dtos.ContactDto;
import com.filadacreche.demo.dtos.TeacherDto;
import com.filadacreche.demo.models.Contact;
import com.filadacreche.demo.models.Teacher;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    ContactDto to(Contact contact);
    List<ContactDto> to(List<Contact> contacts);
}

package com.filadacreche.demo.services;

import com.filadacreche.demo.dtos.ContactCreateDto;
import com.filadacreche.demo.dtos.ContactDto;
import com.filadacreche.demo.dtos.RegisterTeacherOnSubgroupDto;
import com.filadacreche.demo.enums.OwnerType;
import com.filadacreche.demo.exceptions.ResourceName;
import com.filadacreche.demo.exceptions.ResourceNotFoundException;
import com.filadacreche.demo.models.Contact;
import com.filadacreche.demo.models.Subgroup;
import com.filadacreche.demo.models.Teacher;
import com.filadacreche.demo.repositories.ContactRepository;
import com.filadacreche.demo.repositories.SubgroupRepository;
import com.filadacreche.demo.repositories.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RegisterService {
    private final TeacherRepository teacherRepository;
    private final SubgroupRepository subgroupRepository;

    public Subgroup registerTeacherOnSubgroup(RegisterTeacherOnSubgroupDto dto){
        Teacher teacher = getTeacher(dto.getTeacherId());
        Subgroup subgroup = getSubgroup(dto.getSubgroupId());
        List<Teacher> teachers = subgroup.getTeachers();
        teachers.add(teacher);
        subgroup.setTeachers(teachers);
        return this.subgroupRepository.save(subgroup);
    }

    public Subgroup unregisterTeacherOnSubgroup(RegisterTeacherOnSubgroupDto dto) {
        Teacher teacher = getTeacher(dto.getTeacherId());
        Subgroup subgroup = getSubgroup(dto.getSubgroupId());
        List<Teacher> teachers = subgroup.getTeachers();
        teachers.remove(teacher);
        subgroup.setTeachers(teachers);
        return this.subgroupRepository.save(subgroup);
    }

    public Teacher getTeacher(UUID teacherId) {
        return teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ResourceNotFoundException(ResourceName.TEACHER, teacherId));
    }

    public Subgroup getSubgroup(UUID subgroupId) {
        return subgroupRepository.findById(subgroupId)
                .orElseThrow(() -> new ResourceNotFoundException(ResourceName.SUBGROUP, subgroupId));
    }

}

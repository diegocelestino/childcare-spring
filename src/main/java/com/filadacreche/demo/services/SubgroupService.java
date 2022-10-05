package com.filadacreche.demo.services;

import com.filadacreche.demo.dtos.SubgroupCreateDto;
import com.filadacreche.demo.dtos.TeacherCreateDto;
import com.filadacreche.demo.enums.Cycle;
import com.filadacreche.demo.enums.Period;
import com.filadacreche.demo.exceptions.ResourceName;
import com.filadacreche.demo.exceptions.ResourceNotFoundException;
import com.filadacreche.demo.models.Child;
import com.filadacreche.demo.models.Guardian;
import com.filadacreche.demo.models.Subgroup;
import com.filadacreche.demo.models.Teacher;
import com.filadacreche.demo.repositories.SubgroupRepository;
import com.filadacreche.demo.repositories.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SubgroupService {
    private final SubgroupRepository subgroupRepository;




    public Subgroup save(SubgroupCreateDto subgroupCreateDto){
        Subgroup subgroup = new Subgroup(
                Cycle.valueOf(subgroupCreateDto.getCycle()),
                Period.valueOf(subgroupCreateDto.getPeriod()),
                subgroupCreateDto.getCapacity()
        );
        return subgroupRepository.save(subgroup);
    }

    public void appendTeacher(Teacher teacher, UUID subgroupId){
        Subgroup subgroup = getSubgroup(subgroupId);
        List<Teacher> teachers = subgroup.getTeachers();
        teachers.add(teacher);
        subgroup.setTeachers(teachers);
        subgroupRepository.save(subgroup);
    }

    public Subgroup getSubgroup(UUID subgroupId) {
        return subgroupRepository.findById(subgroupId)
                .orElseThrow(() -> new ResourceNotFoundException(ResourceName.SUBGROUP, subgroupId));
    }
}

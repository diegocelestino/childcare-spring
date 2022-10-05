package com.filadacreche.demo.services;

import com.filadacreche.demo.dtos.RoomCreateDto;
import com.filadacreche.demo.dtos.TeacherCreateDto;
import com.filadacreche.demo.models.Room;
import com.filadacreche.demo.models.Teacher;
import com.filadacreche.demo.repositories.RoomRepository;
import com.filadacreche.demo.repositories.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final SubgroupService subgroupService;

    public Teacher save(TeacherCreateDto teacherCreateDto){

        Teacher teacher = new Teacher(
                teacherCreateDto.getName(),
                List.of(subgroupService.getSubgroup(UUID.fromString(teacherCreateDto.getSubgroupId())))
        );
        subgroupService.appendTeacher(teacher, UUID.fromString(teacherCreateDto.getSubgroupId()));
        return teacherRepository.save(teacher);
    }

}

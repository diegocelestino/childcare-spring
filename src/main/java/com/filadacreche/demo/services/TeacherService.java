package com.filadacreche.demo.services;

import com.filadacreche.demo.dtos.RoomCreateDto;
import com.filadacreche.demo.dtos.TeacherCreateDto;
import com.filadacreche.demo.dtos.TeacherDto;
import com.filadacreche.demo.exceptions.ResourceName;
import com.filadacreche.demo.exceptions.ResourceNotFoundException;
import com.filadacreche.demo.models.Room;
import com.filadacreche.demo.models.Subgroup;
import com.filadacreche.demo.models.Teacher;
import com.filadacreche.demo.repositories.RoomRepository;
import com.filadacreche.demo.repositories.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final SubgroupService subgroupService;

    public Teacher save(TeacherCreateDto teacherCreateDto){

        Teacher teacher = new Teacher(
                teacherCreateDto.getName()
        );
        return teacherRepository.save(teacher);
    }

    public void delete(UUID teacherId) {
        teacherRepository.delete(getTeacher(teacherId));
    }

    public Teacher getTeacher(UUID teacherId) {
        return teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ResourceNotFoundException(ResourceName.TEACHER, teacherId));
    }

    public Teacher update(TeacherDto teacherUpdateDto) {
        Teacher teacher = getTeacher(teacherUpdateDto.getId());
        teacher.setName(teacherUpdateDto.getName());
        return teacherRepository.save(teacher);
    }

    public List<Teacher> getTeachers() {
        return this.teacherRepository.findAll();
    }

    public List<Teacher> getTeachersBySubgroupId(UUID subgroupId) {
        Subgroup subgroup = subgroupService.getSubgroup(subgroupId);
        return teacherRepository.findAllBySubgroup(subgroup);
    }
}

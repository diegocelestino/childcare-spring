package com.filadacreche.demo.controllers;

import com.filadacreche.demo.dtos.*;
import com.filadacreche.demo.mappers.RoomMapper;
import com.filadacreche.demo.mappers.TeacherMapper;
import com.filadacreche.demo.models.Room;
import com.filadacreche.demo.models.Subgroup;
import com.filadacreche.demo.models.Teacher;
import com.filadacreche.demo.services.RoomService;
import com.filadacreche.demo.services.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/teacher")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class TeacherController {

    private final TeacherService teacherService;
    private final TeacherMapper teacherMapper;


    @GetMapping
    public ResponseEntity<List<TeacherDto>> index(){
        List<Teacher> teachers = teacherService.getTeachers();
        List<TeacherDto> teachersDto = teacherMapper.to(teachers);
        return ResponseEntity.ok(teachersDto);
    }

    @GetMapping("by")
    public ResponseEntity<List<TeacherDto>> getTeachersBySubgroupId(@RequestParam UUID subgroupId){
        List<Teacher> teachers = teacherService.getTeachersBySubgroupId(subgroupId);
        List<TeacherDto> teachersDto = teacherMapper.to(teachers);
        return ResponseEntity.ok(teachersDto);
    }

    @GetMapping("{teacherId}")
    public ResponseEntity<TeacherDto> show(@PathVariable UUID teacherId){
        Teacher teacher = teacherService.getTeacher(teacherId);
        TeacherDto teacherDto = teacherMapper.to(teacher);
        return ResponseEntity.ok(teacherDto);
    }


    @PostMapping
    public ResponseEntity<TeacherDto> create(@RequestBody TeacherCreateDto teacherCreateDto){
        Teacher teacher = teacherService.save(teacherCreateDto);
        TeacherDto teacherDto = teacherMapper.to(teacher);
        return ResponseEntity.ok(teacherDto);
    }

    @PutMapping
    public ResponseEntity<TeacherDto> update(@RequestBody TeacherDto teacherUpdateDto){
        Teacher teacher = teacherService.update(teacherUpdateDto);
        TeacherDto teacherDto = teacherMapper.to(teacher);
        return ResponseEntity.ok(teacherDto);
    }

    @DeleteMapping("{teacherId}")
    public ResponseEntity<Void> delete(@PathVariable UUID teacherId) {
        teacherService.delete(teacherId);
        return ResponseEntity.noContent().build();
    }
}

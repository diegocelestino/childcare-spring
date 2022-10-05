package com.filadacreche.demo.controllers;

import com.filadacreche.demo.dtos.RoomCreateDto;
import com.filadacreche.demo.dtos.RoomDto;
import com.filadacreche.demo.dtos.TeacherCreateDto;
import com.filadacreche.demo.dtos.TeacherDto;
import com.filadacreche.demo.mappers.RoomMapper;
import com.filadacreche.demo.mappers.TeacherMapper;
import com.filadacreche.demo.models.Room;
import com.filadacreche.demo.models.Teacher;
import com.filadacreche.demo.services.RoomService;
import com.filadacreche.demo.services.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/teacher")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class TeacherController {

    private final TeacherService teacherService;
    private final TeacherMapper teacherMapper;


    @PostMapping
    public ResponseEntity<TeacherDto> create(@RequestBody TeacherCreateDto teacherCreateDto){
        Teacher teacher = teacherService.save(teacherCreateDto);
        TeacherDto teacherDto = teacherMapper.to(teacher);
        return ResponseEntity.ok(teacherDto);
    }

}

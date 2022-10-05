package com.filadacreche.demo.controllers;

import com.filadacreche.demo.dtos.RoomCreateDto;
import com.filadacreche.demo.dtos.RoomDto;
import com.filadacreche.demo.mappers.RoomMapper;
import com.filadacreche.demo.models.Room;
import com.filadacreche.demo.services.ObservationService;
import com.filadacreche.demo.services.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/room")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class RoomController {

    private final RoomService roomService;
    private final RoomMapper roomMapper;

    @PostMapping
    public ResponseEntity<RoomDto> create(@RequestBody RoomCreateDto roomCreateDto){
        Room room = roomService.save(roomCreateDto);
        RoomDto roomDto = roomMapper.to(room);
        return ResponseEntity.ok(roomDto);
    }
}

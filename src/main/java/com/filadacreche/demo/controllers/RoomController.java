package com.filadacreche.demo.controllers;

import com.filadacreche.demo.dtos.*;
import com.filadacreche.demo.mappers.RoomMapper;
import com.filadacreche.demo.models.Room;
import com.filadacreche.demo.models.Subgroup;
import com.filadacreche.demo.services.ObservationService;
import com.filadacreche.demo.services.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/room")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class RoomController {

    private final RoomService roomService;
    private final RoomMapper roomMapper;


    @GetMapping()
    public ResponseEntity<List<RoomDto>> index(){
        List<Room> rooms = roomService.getRooms();
        List<RoomDto> roomsDto = roomMapper.to(rooms);
        return ResponseEntity.ok(roomsDto);
    }

    @PostMapping
    public ResponseEntity<RoomDto> create(@RequestBody RoomCreateDto roomCreateDto){
        Room room = roomService.save(roomCreateDto);
        RoomDto roomDto = roomMapper.to(room);
        return ResponseEntity.ok(roomDto);
    }

    @PutMapping
    public ResponseEntity<RoomDto> update(@RequestBody RoomUpdateDto roomUpdateDto){
        Room room = roomService.update(roomUpdateDto);
        RoomDto roomDto = roomMapper.to(room);
        return ResponseEntity.ok(roomDto);
    }

    @DeleteMapping("{roomId}")
    public ResponseEntity<Void> delete(@PathVariable UUID roomId) {
        roomService.delete(roomId);
        return ResponseEntity.noContent().build();
    }

}

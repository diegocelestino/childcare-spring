package com.filadacreche.demo.services;

import com.filadacreche.demo.dtos.GuardianCreateDto;
import com.filadacreche.demo.dtos.RoomCreateDto;
import com.filadacreche.demo.dtos.RoomUpdateDto;
import com.filadacreche.demo.enums.Period;
import com.filadacreche.demo.exceptions.ResourceName;
import com.filadacreche.demo.exceptions.ResourceNotFoundException;
import com.filadacreche.demo.mappers.RoomMapper;
import com.filadacreche.demo.models.Guardian;
import com.filadacreche.demo.models.Room;
import com.filadacreche.demo.models.Subgroup;
import com.filadacreche.demo.repositories.GuardianRepository;
import com.filadacreche.demo.repositories.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    public Room save(RoomCreateDto roomCreateDto){

        Room room = new Room(
                roomCreateDto.getNumber(),
                roomCreateDto.getName(),
                roomCreateDto.getSedName()
        );
        return roomRepository.save(room);
    }

    public Room update(RoomUpdateDto roomUpdateDto) {
        Room room = getRoom(roomUpdateDto.getId());
        room.setNumber(roomUpdateDto.getNumber());
        room.setName(roomUpdateDto.getName());
        room.setSedName(roomUpdateDto.getSedName());
        return roomRepository.save(room);
    }

    public void delete(UUID roomId) {
        roomRepository.delete(getRoom(roomId));
    }

    public List<Room> getRooms() {
        return roomRepository.findAll();
    }

    public Room getRoom(UUID roomId) {
        return roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException(ResourceName.ROOM, roomId));
    }


}

package com.filadacreche.demo.services;

import com.filadacreche.demo.dtos.GuardianCreateDto;
import com.filadacreche.demo.dtos.RoomCreateDto;
import com.filadacreche.demo.enums.Period;
import com.filadacreche.demo.mappers.RoomMapper;
import com.filadacreche.demo.models.Guardian;
import com.filadacreche.demo.models.Room;
import com.filadacreche.demo.repositories.GuardianRepository;
import com.filadacreche.demo.repositories.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}

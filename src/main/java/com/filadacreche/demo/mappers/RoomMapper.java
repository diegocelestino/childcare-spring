package com.filadacreche.demo.mappers;


import com.filadacreche.demo.dtos.RoomDto;
import com.filadacreche.demo.models.Room;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    RoomDto to(Room room);
    List<RoomDto> to(List<Room> rooms);
}

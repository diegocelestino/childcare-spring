package com.filadacreche.demo.mappers;


import com.filadacreche.demo.dtos.RoomDto;
import com.filadacreche.demo.models.Room;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    RoomDto to(Room room);
}

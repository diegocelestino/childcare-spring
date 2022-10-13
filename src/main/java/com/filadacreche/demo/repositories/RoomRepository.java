package com.filadacreche.demo.repositories;

import com.filadacreche.demo.dtos.RoomDto;
import com.filadacreche.demo.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RoomRepository extends JpaRepository<Room, UUID> {

}

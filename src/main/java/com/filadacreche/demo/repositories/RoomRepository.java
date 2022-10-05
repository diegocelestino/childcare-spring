package com.filadacreche.demo.repositories;

import com.filadacreche.demo.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoomRepository extends JpaRepository<Room, UUID> {
}

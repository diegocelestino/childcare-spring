package com.filadacreche.demo.repositories;

import com.filadacreche.demo.models.Room;
import com.filadacreche.demo.models.Subgroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SubgroupRepository extends JpaRepository<Subgroup, UUID> {
    List<Subgroup> findAllByRoomId(UUID roomId);
}

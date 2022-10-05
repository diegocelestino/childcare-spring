package com.filadacreche.demo.repositories;

import com.filadacreche.demo.models.Room;
import com.filadacreche.demo.models.Subgroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SubgroupRepository extends JpaRepository<Subgroup, UUID> {
}

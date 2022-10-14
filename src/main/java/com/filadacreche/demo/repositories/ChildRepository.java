package com.filadacreche.demo.repositories;

import com.filadacreche.demo.models.Child;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ChildRepository extends JpaRepository<Child, UUID> {

    List<Child> findAllBySubgroupId(UUID subgroupId);
}

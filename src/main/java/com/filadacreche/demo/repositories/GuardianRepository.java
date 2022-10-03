package com.filadacreche.demo.repositories;

import com.filadacreche.demo.models.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GuardianRepository extends JpaRepository<Guardian, UUID> {



}

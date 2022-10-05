package com.filadacreche.demo.repositories;

import com.filadacreche.demo.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TeacherRepository extends JpaRepository<Teacher, UUID> {
}

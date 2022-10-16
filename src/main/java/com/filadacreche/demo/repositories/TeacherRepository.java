package com.filadacreche.demo.repositories;

import com.filadacreche.demo.models.Subgroup;
import com.filadacreche.demo.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

public interface TeacherRepository extends JpaRepository<Teacher, UUID> {

    List<Teacher> findAllBySubgroups(Subgroup subgroup);
}

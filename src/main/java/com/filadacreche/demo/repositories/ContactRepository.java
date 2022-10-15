package com.filadacreche.demo.repositories;

import com.filadacreche.demo.models.Contact;
import com.filadacreche.demo.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ContactRepository extends JpaRepository<Contact, UUID> {
    List<Contact> findAllByChildId(UUID childId);
}

package com.filadacreche.demo.controllers;

import com.filadacreche.demo.dtos.ContactCreateDto;
import com.filadacreche.demo.dtos.ContactDto;
import com.filadacreche.demo.dtos.TeacherCreateDto;
import com.filadacreche.demo.dtos.TeacherDto;
import com.filadacreche.demo.mappers.ContactMapper;
import com.filadacreche.demo.mappers.TeacherMapper;
import com.filadacreche.demo.models.Contact;
import com.filadacreche.demo.models.Teacher;
import com.filadacreche.demo.services.ContactService;
import com.filadacreche.demo.services.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/contact")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class ContactController {

    private final ContactService contactService;
    private final ContactMapper contactMapper;


    @GetMapping("{contactId}")
    public ResponseEntity<ContactDto> show(@PathVariable UUID contactId){
        Contact contact = contactService.getContact(contactId);
        ContactDto contactDto = contactMapper.to(contact);
        return ResponseEntity.ok(contactDto);
    }

    @GetMapping
    public ResponseEntity<List<ContactDto>> getByChildId(@RequestParam UUID childId){
        List<Contact> contacts = contactService.getByChildId(childId);
        List<ContactDto> contactsDto = contactMapper.to(contacts);
        return ResponseEntity.ok(contactsDto);
    }

    @PostMapping
    public ResponseEntity<ContactDto> create(@RequestBody ContactCreateDto contactCreateDto){
        Contact contact = contactService.save(contactCreateDto);
        ContactDto contactDto = contactMapper.to(contact);
        return ResponseEntity.ok(contactDto);
    }

    @PutMapping
    public ResponseEntity<ContactDto> update(@RequestBody ContactDto contactUpdateDto){
        Contact contact = contactService.update(contactUpdateDto);
        ContactDto contactDto = contactMapper.to(contact);
        return ResponseEntity.ok(contactDto);
    }

    @DeleteMapping("{contactId}")
    public ResponseEntity<Void> delete(@PathVariable UUID contactId) {
        contactService.delete(contactId);
        return ResponseEntity.noContent().build();
    }
}

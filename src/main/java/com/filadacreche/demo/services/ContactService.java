package com.filadacreche.demo.services;

import com.filadacreche.demo.dtos.ContactCreateDto;
import com.filadacreche.demo.dtos.ContactDto;
import com.filadacreche.demo.dtos.TeacherCreateDto;
import com.filadacreche.demo.dtos.TeacherDto;
import com.filadacreche.demo.enums.OwnerType;
import com.filadacreche.demo.exceptions.ResourceName;
import com.filadacreche.demo.exceptions.ResourceNotFoundException;
import com.filadacreche.demo.models.Contact;
import com.filadacreche.demo.models.Teacher;
import com.filadacreche.demo.repositories.ContactRepository;
import com.filadacreche.demo.repositories.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ContactService {
    private final ContactRepository contactRepository;
    private final ChildService childService;

    public Contact save(ContactCreateDto contactCreateDto){

        Contact contact = new Contact(
                contactCreateDto.getOwnerName(),
                OwnerType.valueOf(contactCreateDto.getOwnerType()),
                contactCreateDto.getCellphone(),
                childService.getChild(contactCreateDto.getChildId())
        );
        return contactRepository.save(contact);
    }

    public void delete(UUID contactId) {
        contactRepository.delete(getContact(contactId));
    }

    public Contact getContact(UUID contactId) {
        return contactRepository.findById(contactId)
                .orElseThrow(() -> new ResourceNotFoundException(ResourceName.CONTACT, contactId));
    }

    public Contact update(ContactDto contactUpdateDto) {
        Contact contact = getContact(contactUpdateDto.getId());
        contact.setOwnerName(contactUpdateDto.getOwnerName());
        contact.setOwnerType(contactUpdateDto.getOwnerType());
        contact.setCellphone(contactUpdateDto.getCellphone());

        return contactRepository.save(contact);
    }


    public List<Contact> getByChildId(UUID childId) {
        return this.contactRepository.findAllByChildId(childId);
    }
}

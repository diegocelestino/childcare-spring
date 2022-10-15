package com.filadacreche.demo.dtos;

import com.filadacreche.demo.enums.ContactType;
import com.filadacreche.demo.enums.OwnerType;
import lombok.Value;

import java.util.UUID;

@Value
public class ContactDto {
    UUID id;
    String ownerName;
    OwnerType ownerType;
    String cellphone;
    ChildBasicDto child;
}

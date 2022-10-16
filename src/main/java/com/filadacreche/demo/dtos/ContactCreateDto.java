package com.filadacreche.demo.dtos;

import lombok.Getter;
import lombok.Value;

import java.util.UUID;

@Value
@Getter
public class ContactCreateDto {
    String ownerName;
    String ownerType;
    String cellphone;
    UUID childId;
}

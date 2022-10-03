package com.filadacreche.demo.models;

import com.filadacreche.demo.enums.ContactType;
import com.filadacreche.demo.enums.OwnerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "contacts")
public class Contact {
    @Id
    @Column(name = "contact_id")
    private UUID id;

    @Column(nullable = false)
    private String ownerName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OwnerType ownerType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ContactType contactType;

    @Column(nullable = false)
    private String value;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Child child;


    public Contact(UUID id, String ownerName, OwnerType ownerType, ContactType contactType, String value) {
        this.id = id;
        this.ownerName = ownerName;
        this.ownerType = ownerType;
        this.contactType = contactType;
        this.value = value;
    }
}

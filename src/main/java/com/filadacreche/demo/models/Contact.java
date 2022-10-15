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
    private String cellphone;

    @ManyToOne
    @JoinColumn(name = "child_id")
    private Child child;


    public Contact(String ownerName, OwnerType ownerType, String cellphone, Child child) {
        this.id = UUID.randomUUID();
        this.ownerName = ownerName;
        this.ownerType = ownerType;
        this.cellphone = cellphone;
        this.child = child;
    }
}

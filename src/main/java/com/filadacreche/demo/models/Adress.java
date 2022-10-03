package com.filadacreche.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "adresses")
public class Adress {
    @Id
    @Column(name = "adress_id")
    private UUID id;

    @Column(nullable = false)
    private int houseNumber;

    @Column(nullable = false)
    private String streetAddress;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String zipCode;

    @OneToOne(mappedBy = "adress")
    private Child child;

    public Adress(UUID id, int houseNumber, String streetAddress, String city, String state, String zipCode) {
        this.id = id;
        this.houseNumber = houseNumber;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
}

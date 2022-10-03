package com.filadacreche.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "birth_places")
public class BirthPlace {
    @Id
    @Column(name = "birth_place_id")
    private UUID id;

    @Column(nullable = false)
    private String birthCity;

    @Column(nullable = false)
    private String birthState;

    @Column(nullable = false)
    private String nacionality;

    public BirthPlace(String birthCity, String birthState, String nacionality) {
        this.id = UUID.randomUUID();
        this.birthCity = birthCity;
        this.birthState = birthState;
        this.nacionality = nacionality;
    }
}

package com.filadacreche.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@AllArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "kind")
@Table(name = "observations")
public class Observation {
    @Id
    @Column(name = "observation_id")
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "child_id")
    private Child child;

    private String description;


    public Observation() {
        this.id = UUID.randomUUID();
    }
}



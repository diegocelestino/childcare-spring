package com.filadacreche.demo.models;

import com.filadacreche.demo.enums.ObservationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "observations")
public class Observation {
    @Id
    @Column(name = "observation_id")
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "child_id")
    private Child child;

    private ObservationType observationType;

    private String description;


    public Observation(Child child, ObservationType observationType, String description) {
        this.id = UUID.randomUUID();
        this.child = child;
        this.observationType = observationType;
        this.description = description;
    }
}



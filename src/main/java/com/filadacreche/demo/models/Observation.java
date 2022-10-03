package com.filadacreche.demo.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Observation {

    @Id
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "child_id")
    private Child child;

}

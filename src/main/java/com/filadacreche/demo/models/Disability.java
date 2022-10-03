package com.filadacreche.demo.models;

import com.filadacreche.demo.enums.DisabilityType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "disabilities")
public class Disability extends Observation {
    @Id
    @Column(name = "disability_id")
    private UUID id;

    @Column(nullable = false)
    private DisabilityType type;

    private String description;

}

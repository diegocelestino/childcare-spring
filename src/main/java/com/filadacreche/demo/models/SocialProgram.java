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
@Table(name = "social_programs")
public class SocialProgram {

    @Id
    @Column(name = "social_program_id")
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String socialNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Child child;

    public SocialProgram(UUID id, String name, String socialNumber) {
        this.id = id;
        this.name = name;
        this.socialNumber = socialNumber;
    }
}

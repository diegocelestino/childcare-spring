package com.filadacreche.demo.models;

import com.filadacreche.demo.enums.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "children")
public class Child{

    @Id
    @Column(name = "child_id")
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private String registrationNumber;

    @Column(nullable = false)
    private LocalDate registrationDate;

    private MovimentMap movimentMap;

    private String foodRestriction;

    private String uniformDispatch;

    private Boolean uniformDelivered;

    private Boolean census;

    @OneToMany(mappedBy = "child")
    private List<Observation> observations;

    @OneToMany(mappedBy = "child")
    private List<Contact> contacts;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "children_guardians",
            joinColumns = {@JoinColumn(name = "child_id")},
            inverseJoinColumns = {@JoinColumn(name = "guardian_id")}
    )
    private List<Guardian> guardians;

}

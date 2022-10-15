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

    @Enumerated(EnumType.STRING)
    private MovimentMap movimentMap;

    private String uniformDispatch;

    private Boolean uniformDelivered;

    private Boolean census;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subgroup_id")
    private Subgroup subgroup;

    @OneToMany(mappedBy = "child", cascade = CascadeType.ALL)
    private List<Observation> observations;

    @OneToMany(mappedBy = "child")
    private List<Contact> contacts;

    @OneToMany(mappedBy = "child", cascade = CascadeType.ALL)
    private List<Guardian> guardians;

    public Child(String name, LocalDate birthDate, String registrationNumber, LocalDate registrationDate) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.birthDate = birthDate;
        this.registrationNumber = registrationNumber.replaceAll("[^0-9]" , "");
        this.registrationDate = registrationDate;
        this.movimentMap = MovimentMap.NONE;
        this.uniformDispatch = "";
        this.uniformDelivered = false;
        this.census = false;

    }
}

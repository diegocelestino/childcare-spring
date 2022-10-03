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
@Table(name = "housing_components")
public class HousingComponent {
    @Id
    @Column(name = "housing_component_id")
    private UUID id;

    @Column(nullable = false)
    private Integer age;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Child child;

    public HousingComponent(UUID id, Integer age) {
        this.id = id;
        this.age = age;
    }
}

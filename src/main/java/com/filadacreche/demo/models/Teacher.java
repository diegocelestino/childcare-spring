package com.filadacreche.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "teachers")
public class Teacher {

    @Id
    @Column(name = "teacher_id")
    private UUID id;

    private String name;

    @ManyToMany(mappedBy = "teachers")
    private List<Subgroup> subgroup;

    public Teacher(String name, List<Subgroup> subgroup) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.subgroup = subgroup;
    }
}

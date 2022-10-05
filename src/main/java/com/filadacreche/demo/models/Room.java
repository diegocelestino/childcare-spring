package com.filadacreche.demo.models;

import com.filadacreche.demo.enums.Cycle;
import com.filadacreche.demo.enums.Period;
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
@Table(name = "rooms")
public class Room {

    @Id
    @Column(name = "room_id")
    private UUID id;

    @Column(nullable = false)
    private Integer number;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String sedName;

    @OneToMany(mappedBy = "room")
    private List<Subgroup> subgroups;


    public Room(Integer number, String name, String sedName) {
        this.id = UUID.randomUUID();
        this.number = number;
        this.name = name;
        this.sedName = sedName;
    }
}

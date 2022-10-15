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
@Table(name = "subgroups")
public class Subgroup {

    @Id
    @Column(name = "subgroup_id")
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Cycle cycle;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Period period;

    @Column(nullable = false)
    private Integer capacity;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "subgroups_teachers",
            joinColumns = {@JoinColumn(name = "subgroup_id")},
            inverseJoinColumns = {@JoinColumn(name = "teacher_id")}
    )
    private List<Teacher> teachers;

    @OneToMany(mappedBy = "subgroup", cascade = CascadeType.PERSIST)
    private List<Child> children;

    public Subgroup(Cycle cycle, Period period, Integer capacity, Room room) {
        this.id = UUID.randomUUID();
        this.cycle = cycle;
        this.period = period;
        this.capacity = capacity;
        this.room = room;
    }
}

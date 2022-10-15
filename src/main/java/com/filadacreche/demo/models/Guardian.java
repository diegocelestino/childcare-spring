package com.filadacreche.demo.models;

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
@Table(name = "guardians")
public class Guardian {
    @Id
    @Column(name = "guardian_id")
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String cpf;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "child_id", nullable = false)
    private Child child;

    public Guardian(String name, String cpf, Child child) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.cpf = cpf;
        this.child = child;

    }

}

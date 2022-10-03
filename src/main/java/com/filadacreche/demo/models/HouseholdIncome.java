package com.filadacreche.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "household_incomes")
public class HouseholdIncome {

    @Id
    @Column(name = "household_income_id")
    private UUID id;

    @Column(nullable = false)
    private String total;

    @OneToOne(mappedBy = "householdIncome")
    private Child child;

    public HouseholdIncome(UUID id, String total) {
        this.id = id;
        this.total = total;
    }
}

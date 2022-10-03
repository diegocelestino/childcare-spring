package com.filadacreche.demo.models;

import com.filadacreche.demo.enums.HousingType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "housing_status")
public class HousingStatus {

    @Id
    @Column(name = "housing_status_id")
    private UUID id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private HousingType housingType;

    @Column(nullable = false)
    private boolean hasEletricalPower;

    @Column(nullable = false)
    private boolean hasWaterTreatment;

    @Column(nullable = false)
    private boolean hasSewageTreatment;

    @Column(nullable = false)
    private boolean hasGarbageCollection;

    @OneToOne(mappedBy = "housingStatus")
    private Child child;

    public HousingStatus(UUID id, HousingType housingType, boolean hasEletricalPower, boolean hasWaterTreatment, boolean hasSewageTreatment, boolean hasGarbageCollection) {
        this.id = id;
        this.housingType = housingType;
        this.hasEletricalPower = hasEletricalPower;
        this.hasWaterTreatment = hasWaterTreatment;
        this.hasSewageTreatment = hasSewageTreatment;
        this.hasGarbageCollection = hasGarbageCollection;
    }
}

package com.filadacreche.demo.models;

import com.filadacreche.demo.enums.Degree;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@DiscriminatorValue(value = "other")
public class Other extends Observation {

    @Enumerated(EnumType.STRING)
    private Degree degree;

}

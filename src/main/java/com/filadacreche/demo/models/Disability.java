package com.filadacreche.demo.models;

import com.filadacreche.demo.enums.DisabilityType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@DiscriminatorValue(value = "disability")
public class Disability extends Observation {

    @Enumerated(EnumType.STRING)
    private DisabilityType type;

}

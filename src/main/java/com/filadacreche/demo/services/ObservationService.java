package com.filadacreche.demo.services;

import com.filadacreche.demo.dtos.ObservationCreateDto;
import com.filadacreche.demo.dtos.RoomCreateDto;
import com.filadacreche.demo.enums.Degree;
import com.filadacreche.demo.enums.DisabilityType;
import com.filadacreche.demo.models.*;
import com.filadacreche.demo.repositories.ObservationRepository;
import com.filadacreche.demo.repositories.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ObservationService {
    private final ObservationRepository observationRepository;
    private final ChildService childService;

    public Observation save(ObservationCreateDto observationCreateDto){

        Observation observation = getObservationKind(observationCreateDto.getKind());
        observation.setChild(childService.getChild(observationCreateDto.getChildId()));
        observation.setDescription(observationCreateDto.getDescription());

        return observationRepository.save(observation);
    }

    private Observation getObservationKind(String kind){
        Degree[] degrees = Degree.values();
        for (Degree degree : degrees) {
            if (degree.toString().equals(kind))
                return new Other(Degree.valueOf(kind));
        }
        return new Disability(DisabilityType.valueOf(kind));
    }

}

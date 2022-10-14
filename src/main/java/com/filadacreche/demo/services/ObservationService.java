package com.filadacreche.demo.services;

import com.filadacreche.demo.dtos.ObservationCreateDto;
import com.filadacreche.demo.dtos.RoomCreateDto;
import com.filadacreche.demo.enums.Degree;
import com.filadacreche.demo.enums.DisabilityType;
import com.filadacreche.demo.enums.ObservationType;
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

        Observation observation = new Observation(
                childService.getChild(observationCreateDto.getChildId()),
                ObservationType.valueOf(observationCreateDto.getObservationType()),
                observationCreateDto.getDescription()
        );

        return observationRepository.save(observation);
    }

}

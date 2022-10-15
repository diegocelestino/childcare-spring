package com.filadacreche.demo.services;

import com.filadacreche.demo.dtos.ObservationCreateDto;
import com.filadacreche.demo.enums.ObservationType;
import com.filadacreche.demo.models.*;
import com.filadacreche.demo.repositories.ObservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    public List<Observation> getObservationsByChildId(UUID childId) {
        return this.observationRepository.findAllByChildId(childId);
    }

    public void delete(UUID observationId) {
        this.observationRepository.deleteById(observationId);
    }
}

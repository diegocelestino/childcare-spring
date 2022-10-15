package com.filadacreche.demo.controllers;

import com.filadacreche.demo.dtos.ObservationCreateDto;
import com.filadacreche.demo.dtos.ObservationDto;
import com.filadacreche.demo.dtos.RoomCreateDto;
import com.filadacreche.demo.dtos.RoomDto;
import com.filadacreche.demo.mappers.ObservationMapper;
import com.filadacreche.demo.mappers.RoomMapper;
import com.filadacreche.demo.models.Observation;
import com.filadacreche.demo.models.Room;
import com.filadacreche.demo.services.ObservationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/observation")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class ObservationController {

    private final ObservationService observationService;
    private final ObservationMapper observationMapper;

    @GetMapping("{childId}")
    public ResponseEntity<List<ObservationDto>> getObservationsByChildId(@PathVariable UUID childId){
        List<Observation> observations = observationService.getObservationsByChildId(childId);
        List<ObservationDto> observationDtos = observationMapper.to(observations);
        return ResponseEntity.ok(observationDtos);
    }

    @PostMapping
    public ResponseEntity<ObservationDto> create(@RequestBody ObservationCreateDto observationCreateDto){
        Observation observation = observationService.save(observationCreateDto);
        ObservationDto observationDto = observationMapper.to(observation);
        return ResponseEntity.ok(observationDto);
    }
}

package com.filadacreche.demo.controllers;


import com.filadacreche.demo.dtos.GuardianCreateDto;
import com.filadacreche.demo.dtos.GuardianDto;
import com.filadacreche.demo.mappers.GuardianMapper;
import com.filadacreche.demo.models.Guardian;
import com.filadacreche.demo.services.GuardianService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/guardian")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class GuardianController {

    private final GuardianService guardianService;
    private final GuardianMapper guardianMapper;

    @GetMapping("{childId}")
    public ResponseEntity<List<GuardianDto>> show(@PathVariable UUID childId){
        List<Guardian> guardians = guardianService.findByChildId(childId);
        List<GuardianDto> guardiansDto = guardianMapper.to(guardians);
        return ResponseEntity.ok(guardiansDto);
    }

    @PostMapping
    public ResponseEntity<GuardianDto> create(@RequestBody GuardianCreateDto guardianCreateDto){
        Guardian guardian = guardianService.save(guardianCreateDto);
        GuardianDto guardianDto = guardianMapper.to(guardian);
        return ResponseEntity.ok(guardianDto);
    }

    @PutMapping
    public ResponseEntity<GuardianDto> update(@RequestBody GuardianDto guardianDtoIn){
        Guardian guardian = guardianService.update(guardianDtoIn);
        GuardianDto guardianDto = guardianMapper.to(guardian);
        return ResponseEntity.ok(guardianDto);
    }

    @DeleteMapping("{guardianId}")
    public ResponseEntity<Void> delete(@PathVariable UUID guardianId) {
        guardianService.delete(guardianId);
        return ResponseEntity.noContent().build();
    }
}

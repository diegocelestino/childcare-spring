package com.filadacreche.demo.controllers;


import com.filadacreche.demo.dtos.GuardianCreateDto;
import com.filadacreche.demo.dtos.GuardianDto;
import com.filadacreche.demo.mappers.GuardianMapper;
import com.filadacreche.demo.models.Guardian;
import com.filadacreche.demo.services.ChildService;
import com.filadacreche.demo.services.GuardianService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/guardian")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class GuardianController {

    private final GuardianService guardianService;
    private final GuardianMapper guardianMapper;
    private final ChildService childService;

    @PostMapping
    public ResponseEntity<GuardianDto> create(@RequestBody GuardianCreateDto guardianCreateDto){
        Guardian guardian = guardianService.save(guardianCreateDto);
        childService.appendGuardian(guardian, guardianCreateDto.getChildId());
        GuardianDto guardianDto = guardianMapper.to(guardian);
        return ResponseEntity.ok(guardianDto);
    }
}

package com.filadacreche.demo.controllers;

import com.filadacreche.demo.dtos.*;
import com.filadacreche.demo.mappers.SubgroupMapper;
import com.filadacreche.demo.models.Subgroup;
import com.filadacreche.demo.services.SubgroupService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/subgroup")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class SubgroupController {

    private final SubgroupService subgroupService;
    private final SubgroupMapper subgroupMapper;


    @GetMapping("{subgroupId}")
    public ResponseEntity<SubgroupDto> show(@PathVariable UUID subgroupId){
        Subgroup subgroup = subgroupService.getSubgroup(subgroupId);
        SubgroupDto subgroupDto = subgroupMapper.to(subgroup);
        return ResponseEntity.ok(subgroupDto);
    }

    @PostMapping
    public ResponseEntity<SubgroupDto> create(@RequestBody SubgroupCreateDto subgroupCreateDto){
        Subgroup subgroup = subgroupService.save(subgroupCreateDto);
        SubgroupDto subgroupDto = subgroupMapper.to(subgroup);
        return ResponseEntity.ok(subgroupDto);
    }



}

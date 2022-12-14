package com.filadacreche.demo.controllers;

import com.filadacreche.demo.dtos.*;
import com.filadacreche.demo.mappers.SubgroupMapper;
import com.filadacreche.demo.models.Subgroup;
import com.filadacreche.demo.services.RegisterService;
import com.filadacreche.demo.services.SubgroupService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/subgroup")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class SubgroupController {

    private final SubgroupService subgroupService;
    private final SubgroupMapper subgroupMapper;
    private final RegisterService registerService;


    @GetMapping("{subgroupId}")
    public ResponseEntity<SubgroupDto> show(@PathVariable UUID subgroupId){
        Subgroup subgroup = subgroupService.getSubgroup(subgroupId);
        SubgroupDto subgroupDto = subgroupMapper.to(subgroup);
        return ResponseEntity.ok(subgroupDto);
    }

    @GetMapping()
    public ResponseEntity<List<SubgroupDto>> getSubgroupsByRoom(@RequestParam UUID roomId){
        List<Subgroup> subgroups = subgroupService.getSubgroupsByRoom(roomId);
        List<SubgroupDto> subgroupsDto = subgroupMapper.to(subgroups);
        return ResponseEntity.ok(subgroupsDto);
    }

    @PostMapping
    public ResponseEntity<SubgroupDto> create(@RequestBody SubgroupCreateDto subgroupCreateDto){
        Subgroup subgroup = subgroupService.save(subgroupCreateDto);
        SubgroupDto subgroupDto = subgroupMapper.to(subgroup);
        return ResponseEntity.ok(subgroupDto);
    }

    @PostMapping("registerTeacher")
    public ResponseEntity<SubgroupDto> appendTeacher(@RequestBody RegisterTeacherOnSubgroupDto dto){
        Subgroup subgroup = registerService.registerTeacherOnSubgroup(dto);
        SubgroupDto subgroupDto = subgroupMapper.to(subgroup);
        return ResponseEntity.ok(subgroupDto);
    }

    @PostMapping("unregisterTeacher")
    public ResponseEntity<SubgroupDto> removeTeacher(@RequestBody RegisterTeacherOnSubgroupDto dto){
        Subgroup subgroup = registerService.unregisterTeacherOnSubgroup(dto);
        SubgroupDto subgroupDto = subgroupMapper.to(subgroup);
        return ResponseEntity.ok(subgroupDto);
    }

    @PutMapping
    public ResponseEntity<SubgroupDto> update(@RequestBody SubgroupUpdateDto subgroupUpdateDto){
        Subgroup subgroup = subgroupService.update(subgroupUpdateDto);
        SubgroupDto subgroupDto = subgroupMapper.to(subgroup);
        return ResponseEntity.ok(subgroupDto);
    }

    @DeleteMapping("{subgroupId}")
    public ResponseEntity<Void> delete(@PathVariable UUID subgroupId) {
        subgroupService.delete(subgroupId);
        return ResponseEntity.noContent().build();
    }
}

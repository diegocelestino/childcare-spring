package com.filadacreche.demo.controllers;

import com.filadacreche.demo.dtos.ChildCreateDto;
import com.filadacreche.demo.dtos.ChildDto;
import com.filadacreche.demo.dtos.RegisterDto;
import com.filadacreche.demo.mappers.ChildMapper;
import com.filadacreche.demo.models.Child;
import com.filadacreche.demo.services.ChildService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/child")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class ChildController {

    private final ChildService childService;
    private final ChildMapper childMapper;

    @GetMapping()
    public ResponseEntity<Page<ChildDto>> index(
            @PageableDefault(page = 0, size = 20, sort = "name") Pageable pageable) {

        Page<Child> children = childService.getChildren(pageable);
        return ResponseEntity.ok(children.map(childMapper::to));
    }

    @GetMapping("{childId}")
    public ResponseEntity<ChildDto> show(@PathVariable UUID childId) {
        Child child = childService.getChild(childId);
        ChildDto childDto = childMapper.to(child);
        return ResponseEntity.ok(childDto);
    }

    @PostMapping
    public ResponseEntity<ChildDto> create(@RequestBody ChildCreateDto childCreateDto){
        Child child = childService.save(childCreateDto);
        ChildDto childDto = childMapper.to(child);
        return ResponseEntity.ok(childDto);
    }

    @PutMapping
    public ResponseEntity<ChildDto> update(@RequestBody ChildDto childDtoIn){
        Child child = childService.update(childDtoIn);
        ChildDto childDto = childMapper.to(child);
        return ResponseEntity.ok(childDto);
    }

    @DeleteMapping("{childId}")
    public ResponseEntity<Void> delete(@PathVariable UUID childId) {
        childService.delete(childId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("register")
    public ResponseEntity<ChildDto> register(@RequestBody RegisterDto registerDto){
        Child child = childService.register(registerDto);
        ChildDto childDto = childMapper.to(child);
        return ResponseEntity.ok(childDto);
    }

    @PostMapping("unregister")
    public ResponseEntity<ChildDto> unregister(@RequestBody RegisterDto registerDto){
        Child child = childService.unregister(registerDto);
        ChildDto childDto = childMapper.to(child);
        return ResponseEntity.ok(childDto);
    }
}

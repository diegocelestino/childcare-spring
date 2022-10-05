package com.filadacreche.demo.controllers;

import com.filadacreche.demo.dtos.ChildCreateDto;
import com.filadacreche.demo.dtos.ChildDto;
import com.filadacreche.demo.mappers.ChildMapper;
import com.filadacreche.demo.models.Child;
import com.filadacreche.demo.services.ChildService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        Page<Child> children = childService.getAccounts(pageable);
        return ResponseEntity.ok(children.map(childMapper::to));
    }

    @PostMapping
    public ResponseEntity<ChildDto> create(@RequestBody ChildCreateDto childCreateDto){
        Child child = childService.save(childCreateDto);
        ChildDto childDto = childMapper.to(child);
        return ResponseEntity.ok(childDto);
    }



}

package com.filadacreche.demo.services;

import com.filadacreche.demo.dtos.ChildCreateDto;
import com.filadacreche.demo.dtos.ChildDto;
import com.filadacreche.demo.dtos.RegisterDto;
import com.filadacreche.demo.enums.MovimentMap;
import com.filadacreche.demo.exceptions.ResourceName;
import com.filadacreche.demo.exceptions.ResourceNotFoundException;
import com.filadacreche.demo.models.Child;
import com.filadacreche.demo.models.Guardian;
import com.filadacreche.demo.repositories.ChildRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Log4j2
public class ChildService {
    private final ChildRepository childRepository;
    private final SubgroupService subgroupService;

    public Child save(ChildCreateDto childCreateDto){
        Child child = new Child(
                childCreateDto.getName(),
                childCreateDto.getBirthDate(),
                childCreateDto.getRegistrationNumber(),
                childCreateDto.getRegistrationDate()
        );

        child.setSubgroup(subgroupService.getSubgroup(childCreateDto.getSubgroupId()));

        return childRepository.save(child);
    }

    public List<Child> getChildrenBySubgroup(UUID subgroupId) {
        return this.childRepository.findAllBySubgroupId(subgroupId);
    }

    public void appendGuardian(Guardian guardian, UUID childId){
        Child child = getChild(childId);
        List<Guardian> guardians = child.getGuardians();
        guardians.add(guardian);
        child.setGuardians(guardians);
        childRepository.save(child);
    }

    public Child register(RegisterDto registerDto) {
        Child child = getChild(registerDto.getChildId());
        child.setSubgroup(subgroupService.getSubgroup(registerDto.getSubgroupId()));
        return childRepository.save(child);
    }

    public Child unregister(RegisterDto registerDto) {
        Child child = getChild(registerDto.getChildId());
        child.setSubgroup(null);
        return childRepository.save(child);
    }

    public void delete(UUID childId) {
        childRepository.delete(getChild(childId));
    }

    public Child update(ChildDto childDtoIn) {
        Child child = getChild(childDtoIn.getId());
        child.setName(childDtoIn.getName());
        child.setBirthDate(LocalDate.parse(childDtoIn.getBirthDate()));
        child.setRegistrationNumber(childDtoIn.getRegistrationNumber());
        child.setRegistrationDate(childDtoIn.getRegistrationDate());
        child.setMovimentMap(MovimentMap.valueOf(childDtoIn.getMovimentMap()));
        child.setUniformDispatch(childDtoIn.getUniformDispatch());
        child.setUniformDelivered(childDtoIn.getUniformDelivered());
        child.setCensus(childDtoIn.getCensus());
        return childRepository.save(child);
    }

    public Child getChild(UUID childId) {
        return childRepository.findById(childId)
                .orElseThrow(() -> new ResourceNotFoundException(ResourceName.CHILD, childId));
    }

    public Page<Child> getChildren(Pageable pageable) {
        return childRepository.findAll(pageable);
    }

}

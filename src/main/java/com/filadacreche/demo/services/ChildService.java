package com.filadacreche.demo.services;

import com.filadacreche.demo.dtos.ChildCreateDto;
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
                childCreateDto.getRegistrationDate(),
                subgroupService.getSubgroup(childCreateDto.getSubgroupId())
        );
        return childRepository.save(child);
    }

    public void appendGuardian(Guardian guardian, UUID childId){
        Child child = getChild(childId);
        log.warn(child.getName());
        List<Guardian> guardians = child.getGuardians();
        guardians.add(guardian);
        child.setGuardians(guardians);
        childRepository.save(child);
    }

    public Child getChild(UUID childId) {
        return childRepository.findById(childId)
                .orElseThrow(() -> new ResourceNotFoundException(ResourceName.CHILD, childId));
    }

    public Page<Child> getAccounts(Pageable pageable) {
        return childRepository.findAll(pageable);
    }
}

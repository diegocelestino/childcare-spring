package com.filadacreche.demo.services;

import com.filadacreche.demo.dtos.ChildCreateDto;
import com.filadacreche.demo.enums.Cycle;
import com.filadacreche.demo.enums.Gender;
import com.filadacreche.demo.enums.Period;
import com.filadacreche.demo.enums.Race;
import com.filadacreche.demo.exceptions.ResourceName;
import com.filadacreche.demo.exceptions.ResourceNotFoundException;
import com.filadacreche.demo.models.BirthPlace;
import com.filadacreche.demo.models.Child;
import com.filadacreche.demo.models.Guardian;
import com.filadacreche.demo.repositories.ChildRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Log4j2
public class ChildService {
    private final ChildRepository childRepository;

    public Child save(ChildCreateDto childDto){
        Child child = new Child(
                childDto.getName(),
                LocalDate.parse(childDto.getBirthDate()),
                Gender.valueOf(childDto.getGender()),
                new BirthPlace(
                        childDto.getBirthCity(),
                        childDto.getBirthState(),
                        childDto.getNacionality()),
                Race.valueOf(childDto.getRace()),
                Cycle.valueOf(childDto.getCycle()),
                Period.valueOf(childDto.getPeriod())
        );

        return this.childRepository.save(child);
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
}

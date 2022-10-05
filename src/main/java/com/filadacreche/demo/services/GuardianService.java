package com.filadacreche.demo.services;

import com.filadacreche.demo.dtos.GuardianCreateDto;
import com.filadacreche.demo.enums.Period;
import com.filadacreche.demo.models.Child;
import com.filadacreche.demo.models.Guardian;
import com.filadacreche.demo.repositories.ChildRepository;
import com.filadacreche.demo.repositories.GuardianRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class GuardianService {
    private final GuardianRepository guardianRepository;
    private final ChildService childService;

    public Guardian save(GuardianCreateDto guardianCreateDto){

        Guardian guardian = new Guardian(
                guardianCreateDto.getName(),
                guardianCreateDto.getCpf(),
                Period.valueOf(guardianCreateDto.getWorkPeriod())
        );
        childService.appendGuardian(guardian, guardianCreateDto.getChildId());
        return guardianRepository.save(guardian);
    }


    public List<Guardian> findByChildId(UUID childId) {
        List<Guardian> guardians = guardianRepository.findByChildId(childId);
        return guardians;
    }
}

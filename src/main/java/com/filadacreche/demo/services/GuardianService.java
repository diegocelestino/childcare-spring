package com.filadacreche.demo.services;

import com.filadacreche.demo.dtos.GuardianCreateDto;
import com.filadacreche.demo.dtos.GuardianDto;
import com.filadacreche.demo.enums.Period;
import com.filadacreche.demo.exceptions.ResourceName;
import com.filadacreche.demo.exceptions.ResourceNotFoundException;
import com.filadacreche.demo.models.Guardian;
import com.filadacreche.demo.repositories.GuardianRepository;
import lombok.AllArgsConstructor;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
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
                childService.getChild(guardianCreateDto.getChildId())
        );
        return guardianRepository.save(guardian);
    }

    public Guardian update(GuardianDto guardianDtoIn) {
        Guardian guardian = getGuardian(guardianDtoIn.getId());
        guardian.setName(guardianDtoIn.getName());
        guardian.setCpf(guardianDtoIn.getCpf());
        return guardianRepository.save(guardian);
    }

    public List<Guardian> findByChildId(UUID childId) {
        return guardianRepository.findByChildId(childId);
    }

    public void delete(UUID guardianId) {
        guardianRepository.deleteById(guardianId);
    }

    public Guardian getGuardian(UUID guardianId) {
        return guardianRepository.findById(guardianId)
                .orElseThrow(() -> new ResourceNotFoundException(ResourceName.GUARDIAN, guardianId));
    }


}

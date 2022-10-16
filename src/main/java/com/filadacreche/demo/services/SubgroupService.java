package com.filadacreche.demo.services;

import com.filadacreche.demo.dtos.RegisterTeacherOnSubgroupDto;
import com.filadacreche.demo.dtos.SubgroupCreateDto;
import com.filadacreche.demo.dtos.SubgroupUpdateDto;
import com.filadacreche.demo.enums.Cycle;
import com.filadacreche.demo.enums.Period;
import com.filadacreche.demo.exceptions.ResourceName;
import com.filadacreche.demo.exceptions.ResourceNotFoundException;
import com.filadacreche.demo.models.Subgroup;
import com.filadacreche.demo.repositories.SubgroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SubgroupService {
    private final SubgroupRepository subgroupRepository;
    private final RoomService roomService;
    private final RegisterService registerService;

    public Subgroup save(SubgroupCreateDto subgroupCreateDto){
        Subgroup subgroup = new Subgroup(
                Cycle.valueOf(subgroupCreateDto.getCycle()),
                Period.valueOf(subgroupCreateDto.getPeriod()),
                subgroupCreateDto.getCapacity(),
                roomService.getRoom(subgroupCreateDto.getRoomId())
        );
        return subgroupRepository.save(subgroup);
    }

    public Subgroup update(SubgroupUpdateDto subgroupUpdateDto) {
        Subgroup subgroup = getSubgroup(subgroupUpdateDto.getId());
        subgroup.setCycle(Cycle.valueOf(subgroupUpdateDto.getCycle()));
        subgroup.setPeriod(Period.valueOf(subgroupUpdateDto.getPeriod()));
        subgroup.setCapacity(subgroup.getCapacity());
        return subgroupRepository.save(subgroup);
    }

    public List<Subgroup> getSubgroupsByRoom(UUID roomId) {
        return subgroupRepository.findAllByRoomId(roomId);
    }

    public Subgroup getSubgroup(UUID subgroupId) {
        return subgroupRepository.findById(subgroupId)
                .orElseThrow(() -> new ResourceNotFoundException(ResourceName.SUBGROUP, subgroupId));
    }

    public void delete(UUID subgroupId) {
        subgroupRepository.delete(getSubgroup(subgroupId));
    }

    public Subgroup appendTeacher(RegisterTeacherOnSubgroupDto dto){
        return registerService.registerTeacherOnSubgroup(dto);
    }

    public Subgroup removeTeacher(RegisterTeacherOnSubgroupDto dto) {
        return registerService.unregisterTeacherOnSubgroup(dto);
    }
}

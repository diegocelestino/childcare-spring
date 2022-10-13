package com.filadacreche.demo.mappers;


import com.filadacreche.demo.dtos.SubgroupBasicDto;
import com.filadacreche.demo.dtos.SubgroupDto;
import com.filadacreche.demo.models.Subgroup;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubgroupMapper {
    SubgroupDto to(Subgroup subgroup);
    List<SubgroupDto> to(List<Subgroup> subgroups);
}

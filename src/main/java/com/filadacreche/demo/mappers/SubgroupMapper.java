package com.filadacreche.demo.mappers;


import com.filadacreche.demo.dtos.SubgroupDto;
import com.filadacreche.demo.models.Subgroup;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubgroupMapper {
    SubgroupDto to(Subgroup subgroup);
}

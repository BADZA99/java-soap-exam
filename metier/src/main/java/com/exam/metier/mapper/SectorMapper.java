package com.exam.metier.mapper;

import com.exam.metier.dto.SectorDto;
import com.exam.metier.entity.Sectors;

public class SectorMapper {

    public static SectorDto toDto(Sectors sector) {
        return new SectorDto(sector.getId(), sector.getName());
    }

    public static Sectors toEntity(SectorDto dto) {
        Sectors sector = new Sectors();
        sector.setName(dto.getName());
        return sector;
    }
}

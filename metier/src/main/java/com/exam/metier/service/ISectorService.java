package com.exam.metier.service;

import com.exam.metier.dto.SectorDto;
import java.util.List;

public interface ISectorService {
    void addSector(SectorDto sectorDto);

    void updateSector(SectorDto sectorDto);

    void deleteSector(int id);

    List<SectorDto> getAllSectors();

    SectorDto getSectorById(int id);
}

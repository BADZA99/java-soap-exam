package com.exam.metier.service;

import com.exam.metier.dao.ISectorDao;
import com.exam.metier.dto.SectorDto;
import com.exam.metier.entity.Sectors;
import com.exam.metier.exception.SectorNotFoundException;
import com.exam.metier.mapper.SectorMapper;
import java.util.List;
import java.util.stream.Collectors;

public class SectorService implements ISectorService {

    private final ISectorDao sectorDao;

    public SectorService(ISectorDao sectorDao) {
        this.sectorDao = sectorDao;
    }

    @Override
    public void addSector(SectorDto sectorDto) {
        Sectors sector = SectorMapper.toEntity(sectorDto);
        sectorDao.addSector(sector);
    }

    @Override
    public void updateSector(SectorDto sectorDto) {
        Sectors sector = sectorDao.getSectorById(sectorDto.getId());
        if (sector == null) {
            throw new SectorNotFoundException("Sector not found");
        }
        sector.setName(sectorDto.getName());
        sectorDao.updateSector(sector);
    }

    @Override
    public void deleteSector(int id) {
        Sectors sector = sectorDao.getSectorById(id);
        if (sector == null) {
            throw new SectorNotFoundException("Sector not found");
        }
        sectorDao.deleteSector(id);
    }

    @Override
    public List<SectorDto> getAllSectors() {
        List<Sectors> sectors = sectorDao.getAllSectors();
        System.out.println("Secteurs récupérés dans SectorService : " + sectors);
        return sectors.stream()
                      .map(sector -> new SectorDto(sector.getId(), sector.getName()))
                      .collect(Collectors.toList());
    }

    @Override
    public SectorDto getSectorById(int id) {
        Sectors sector = sectorDao.getSectorById(id);
        if (sector == null) {
            throw new SectorNotFoundException("Sector not found");
        }
        return SectorMapper.toDto(sector);
    }
}

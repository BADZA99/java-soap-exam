package com.groupeisi.webservice.service;

import java.util.List;

import com.exam.metier.dao.SectorDao;
import com.exam.metier.dto.SectorDto;
import com.exam.metier.service.ISectorService;
import com.exam.metier.service.SectorService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService
public class SectorWebServiceImpl implements SectorWebService {

    private final ISectorService sectorService;

    // No-argument constructor
    public SectorWebServiceImpl() {
        this.sectorService = new SectorService(new SectorDao());
    }

    public SectorWebServiceImpl(ISectorService sectorService) {
        this.sectorService = sectorService;
    }

    @Override
    @WebMethod(operationName = "allSectors")
    public List<SectorDto> all() {
        System.out.println("Méthode allSectors appelée dans SectorWebServiceImpl");
        List<SectorDto> sectors = sectorService.getAllSectors();
        System.out.println("Secteurs récupérés dans allSectors : " + sectors);
        return sectors;
    }

    @Override
    @WebMethod(operationName = "saveSector")
    public SectorDto save(@WebParam(name = "sectorDto") SectorDto sectorDto) {
        try {
            sectorService.addSector(sectorDto);
            System.out.println("Sector added successfully: " + sectorDto);
            return sectorDto;
        } catch (Exception e) {
            System.err.println("Error while adding sector: " + e.getMessage());
            throw new RuntimeException("Error while adding sector: " + e.getMessage());
        }
    }

    @Override
    @WebMethod(operationName = "getSector")
    public SectorDto get(@WebParam(name = "id") int id) {
        try {
            SectorDto sector = sectorService.getSectorById(id);
            System.out.println("Sector retrieved successfully: " + sector);
            return sector;
        } catch (Exception e) {
            System.err.println("Error while retrieving sector: " + e.getMessage());
            throw new RuntimeException("Error while retrieving sector: " + e.getMessage());
        }
    }
}

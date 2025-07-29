package com.groupeisi.webservice.service;

import java.util.List;

import com.exam.metier.dto.SectorDto;
import com.exam.metier.service.ISectorService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService
public class SectorWebServiceImpl implements SectorWebService {

    private final ISectorService sectorService;

    // No-argument constructor
    public SectorWebServiceImpl() {
        // Optionally initialize sectorService with a default implementation
        // Example: this.sectorService = new DefaultSectorService();
        this.sectorService = null;
    }

    public SectorWebServiceImpl(ISectorService sectorService) {
        this.sectorService = sectorService;
    }

    @Override
    @WebMethod(operationName = "getSector")
    public SectorDto get(@WebParam(name = "id") Long id) {
        return sectorService.getSectorById(id);
    }

    @Override
    @WebMethod(operationName = "allSectors")
    public List<SectorDto> all() {
        return sectorService.getAllSectors();
    }

    @Override
    @WebMethod(operationName = "saveSector")
    public SectorDto save(@WebParam(name = "sectorDto") SectorDto sectorDto) {
        sectorService.addSector(sectorDto);
        return sectorDto;
    }
}

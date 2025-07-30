package com.groupeisi.webservice.service;

import java.util.List;

import com.exam.metier.dto.SectorDto;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService
public interface SectorWebService {

    @WebMethod(operationName = "getSector")
    SectorDto get(@WebParam(name = "id") int id);

    @WebMethod(operationName = "allSectors")
    List<SectorDto> all();

    @WebMethod(operationName = "saveSector")
    SectorDto save(@WebParam(name = "sectorDto") SectorDto sectorDto);
}

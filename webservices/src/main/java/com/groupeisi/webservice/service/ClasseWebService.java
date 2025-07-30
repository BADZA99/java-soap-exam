package com.groupeisi.webservice.service;

import java.util.List;
import com.exam.metier.dto.ClasseDto;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.WebParam;

@WebService
public interface ClasseWebService {
    @WebMethod(operationName = "getClasse")
    ClasseDto get(@WebParam(name = "id") Long idClasse);

    @WebMethod(operationName = "allClasses")
    List<ClasseDto> all();

    //@WebMethod(operationName = "saveClasse")
    //ClasseDto save(@WebParam(name = "classeDto") ClasseDto classeDto);
}

package com.groupeisi.webservice.service;

import java.util.List;
import com.exam.metier.dto.ClasseDto;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.xml.bind.annotation.XmlSeeAlso;

@WebService(targetNamespace = "http://service.webservice.groupeisi.com/")
@XmlSeeAlso({ClasseDto.class})
public interface ClasseWebService {
    @WebMethod(operationName = "getClasse")
    @WebResult(name = "return")
    ClasseDto get(@WebParam(name = "id") int id);

    @WebMethod(operationName = "allClasses")
    @WebResult(name = "return")
    List<ClasseDto> all();

    /**
     * Saves a new ClasseDto object.
     *
     * @param classeDto The ClasseDto object to be saved. Must not be null and must have a valid className.
     * @return The saved ClasseDto object.
     * @throws RuntimeException if the className is null or empty.
     */
   /* @WebMethod(operationName = "saveClasse")
    @WebResult(name = "return")
    ClasseDto save(@WebParam(name = "classeDto") ClasseDto classeDto);*/
}
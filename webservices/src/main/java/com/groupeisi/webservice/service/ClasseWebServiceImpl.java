package com.groupeisi.webservice.service;

import java.util.List;

import com.exam.metier.dto.ClasseDto;
import com.exam.metier.service.IClasseService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlElement;

@WebService
public class ClasseWebServiceImpl implements ClasseWebService {

    private final IClasseService classeService;

    // No-argument constructor
    public ClasseWebServiceImpl() {
        // Optionally initialize classeService with a default implementation
        // Example: this.classeService = new DefaultClasseService();
        this.classeService = null; // or some default instance
    }

    public ClasseWebServiceImpl(IClasseService classeService) {
        this.classeService = classeService;
    }



    @Override
    @WebMethod(operationName = "getClasse")
    public ClasseDto get(@WebParam(name = "id") Long idClasse) {
        return classeService.getClasseById(idClasse);
    }

    @Override
    @WebMethod(operationName = "allClasses")
    public List<ClasseDto> all() {
        return classeService.getAllClasses();
    }

    @Override
    @WebMethod(operationName = "saveClasse")
    public ClasseDto save(@WebParam(name = "classeDto") ClasseDto classeDto) {
        classeService.addClasse(classeDto) ;
        return classeDto;
    }
}

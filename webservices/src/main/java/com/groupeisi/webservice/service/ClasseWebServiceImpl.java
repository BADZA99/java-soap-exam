package com.groupeisi.webservice.service;

import java.util.List;

import com.exam.metier.dao.ClasseDao;
import com.exam.metier.dto.ClasseDto;
import com.exam.metier.service.ClasseService;
import com.exam.metier.service.IClasseService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.WebParam;

@WebService(endpointInterface = "com.groupeisi.webservice.service.ClasseWebService")
public class ClasseWebServiceImpl implements ClasseWebService {

    private final IClasseService classeService;

    // No-argument constructor
    public ClasseWebServiceImpl() {
        // Initialize classeService with a default implementation
        this.classeService = new ClasseService(new ClasseDao());
        // Replace with actual implementation
    }

    public ClasseWebServiceImpl(IClasseService classeService) {
        this.classeService = classeService;
    }



    @Override
    @WebMethod(operationName = "getClasse")
    public ClasseDto get(@WebParam(name = "id") int idClasse) {
        ClasseDto classeDto = classeService.getClasseById(idClasse);
        System.out.println("Returning ClasseDto: " + classeDto);
        return classeDto;
    }

    @Override
    @WebMethod(operationName = "allClasses")
    public List<ClasseDto> all() {
        return classeService.getAllClasses();
    }

    //@Override
    //@WebMethod(operationName = "saveClasse")
    //public ClasseDto save(@WebParam(name = "classeDto") ClasseDto classeDto) {
        //if (classeDto == null || classeDto.getClassName() == null || classeDto.getClassName().isEmpty()) {
            //throw new IllegalArgumentException("Class name is required");
        //}

        //if (classeDto.getSectorId() == null) {
            //throw new IllegalArgumentException("Sector ID is required");
        //}

        //classeService.addClasse(classeDto);
        //classeDto.setDescription("Class saved successfully");
        //return classeDto;
    //}
}

package com.exam.metier.service;

import com.exam.metier.dto.ClasseDto;
import java.util.List;

public interface IClasseService {
    ClasseDto addClasse(ClasseDto classeDto);

    void updateClasse(ClasseDto classeDto);

    void deleteClasse(int id);

    List<ClasseDto> getAllClasses();

    List<ClasseDto> getClassesBySector(int sectorId);

    ClasseDto getClasseById(int id);
}

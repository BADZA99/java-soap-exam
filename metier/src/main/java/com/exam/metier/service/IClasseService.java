package com.exam.metier.service;

import com.exam.metier.dto.ClasseDto;
import java.util.List;

public interface IClasseService {
    void addClasse(ClasseDto classeDto);

    void updateClasse(ClasseDto classeDto);

    void deleteClasse(Long id);

    List<ClasseDto> getAllClasses();

    List<ClasseDto> getClassesBySector(Long sectorId);

    ClasseDto getClasseById(Long id);
}

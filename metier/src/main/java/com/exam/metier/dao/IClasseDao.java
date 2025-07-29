package com.exam.metier.dao;

import com.exam.metier.entity.Classes;
import java.util.List;

public interface IClasseDao {
    void addClasse(Classes classe);

    void updateClasse(Classes classe);

    void deleteClasse(Long id);

    List<Classes> getAllClasses();

    List<Classes> getClassesBySector(Long sectorId);

    Classes getClasseById(Long id);
}

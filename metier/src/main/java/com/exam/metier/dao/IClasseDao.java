package com.exam.metier.dao;

import com.exam.metier.entity.Classes;
import java.util.List;

public interface IClasseDao {
    void addClasse(Classes classe);

    void updateClasse(Classes classe);

    void deleteClasse(int id);

    List<Classes> getAllClasses();

    List<Classes> getClassesBySector(int sectorId);

    Classes getClasseById(int id);
}

package com.exam.metier.dao;

import com.exam.metier.entity.Sectors;
import java.util.List;

public interface ISectorDao {
    void addSector(Sectors sector);

    void updateSector(Sectors sector);

    void deleteSector(int id);

    List<Sectors> getAllSectors();

    Sectors getSectorById(int id);
}

package com.exam.metier.mapper;

import com.exam.metier.dto.ClasseDto;
import com.exam.metier.entity.Classes;
import com.exam.metier.entity.Sectors;

public class ClasseMapper {

    public static ClasseDto toDto(Classes classe) {
        return new ClasseDto(
            classe.getId(),
            classe.getClassName(),
            classe.getDescription(),
            classe.getSector() != null ? classe.getSector().getId() : 0
        );
    }

    public static Classes toEntity(ClasseDto dto) {
        Classes classe = new Classes();
        classe.setId(dto.getId());
        classe.setClassName(dto.getClassName());
        classe.setDescription(dto.getDescription());
        if (dto.getSectorId() != 0) {
            Sectors sector = new Sectors();
        }
        return classe;
    }
}

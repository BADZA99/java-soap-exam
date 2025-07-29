package com.exam.metier.mapper;

import com.exam.metier.dto.ClasseDto;
import com.exam.metier.entity.Classes;

public class ClasseMapper {

    public static ClasseDto toDto(Classes classe) {
        return new ClasseDto(classe.getId(), classe.getClassName(), classe.getDescription(),
                classe.getSector().getId());
    }

    public static Classes toEntity(ClasseDto dto) {
        Classes classe = new Classes();
        classe.setId(dto.getId());
        classe.setClassName(dto.getClassName());
        classe.setDescription(dto.getDescription());
        return classe;
    }
}

package com.exam.metier.service;

import com.exam.metier.dao.IClasseDao;
import com.exam.metier.dto.ClasseDto;
import com.exam.metier.entity.Classes;
import com.exam.metier.exception.ClasseNotFoundException;
import com.exam.metier.mapper.ClasseMapper;
import java.util.List;
import java.util.stream.Collectors;

public class ClasseService implements IClasseService {

    private final IClasseDao classeDao;

    public ClasseService(IClasseDao classeDao) {
        this.classeDao = classeDao;
    }

    @Override
    public void addClasse(ClasseDto classeDto) {
        Classes classe = ClasseMapper.toEntity(classeDto);
        classeDao.addClasse(classe);
    }

    @Override
    public void updateClasse(ClasseDto classeDto) {
        Classes classe = classeDao.getClasseById(classeDto.getId());
        if (classe == null) {
            throw new ClasseNotFoundException("Classe not found");
        }
        classe.setClassName(classeDto.getClassName());
        classe.setDescription(classeDto.getDescription());
        classeDao.updateClasse(classe);
    }

    @Override
    public void deleteClasse(int id) {
        Classes classe = classeDao.getClasseById(id);
        if (classe == null) {
            throw new ClasseNotFoundException("Classe not found");
        }
        classeDao.deleteClasse(id);
    }

    @Override
    public List<ClasseDto> getAllClasses() {
        return classeDao.getAllClasses().stream()
                .map(ClasseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClasseDto> getClassesBySector(int sectorId) {
        return classeDao.getClassesBySector(sectorId).stream()
                .map(ClasseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClasseDto getClasseById(int id) {
        Classes classe = classeDao.getClasseById(id);
        if (classe == null) {
            throw new ClasseNotFoundException("Classe not found");
        }
        return ClasseMapper.toDto(classe);
    }
}

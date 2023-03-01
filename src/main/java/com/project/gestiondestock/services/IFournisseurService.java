package com.project.gestiondestock.services;

import com.project.gestiondestock.dto.FournisseurDto;

import java.util.List;

public interface IFournisseurService {
    FournisseurDto save(FournisseurDto dto);
    FournisseurDto findById(Integer id);
    List<FournisseurDto> findAll();
    void delete(Integer id);

}

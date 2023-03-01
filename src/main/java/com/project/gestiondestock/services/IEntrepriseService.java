package com.project.gestiondestock.services;

import com.project.gestiondestock.dto.EntrepriseDto;

import java.util.List;

public interface IEntrepriseService {
    EntrepriseDto save(EntrepriseDto dto);
    EntrepriseDto findById(Integer id);
    List<EntrepriseDto> findAll();
    void delete(Integer id);

}

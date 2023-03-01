package com.project.gestiondestock.services;

import com.project.gestiondestock.dto.VentesDto;

import java.util.List;

public interface IVentesService {
    VentesDto save(VentesDto dto);

    VentesDto findById(Integer id);

    VentesDto findByCode(String code);

    List<VentesDto> findAll();

    void delete(Integer id);
}

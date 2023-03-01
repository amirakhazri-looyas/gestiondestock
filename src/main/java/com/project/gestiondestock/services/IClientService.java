package com.project.gestiondestock.services;

import com.project.gestiondestock.dto.ClientDto;

import java.util.List;

public interface IClientService {

    ClientDto save(ClientDto dto);
    ClientDto findById(Integer id);
    List<ClientDto> findAll();
    void delete(Integer id);

}

package com.project.gestiondestock.services.impl;

import com.project.gestiondestock.dto.ClientDto;
import com.project.gestiondestock.services.IClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ClientService implements IClientService {

    @Override
    public ClientDto save(ClientDto dto) {
        return null;
    }

    @Override
    public ClientDto findById(Integer id) {
        return null;
    }

    @Override
    public List<ClientDto> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }


}

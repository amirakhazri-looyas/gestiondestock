package com.project.gestiondestock.services;

import com.project.gestiondestock.dto.ChangerMotDePasseUtilisateurDto;
import com.project.gestiondestock.dto.UtilisateurDto;

import java.util.List;

public interface IUtilisateurService {

    UtilisateurDto save(UtilisateurDto dto);

    UtilisateurDto findById(Integer id);

    List<UtilisateurDto> findAll();

    void delete(Integer id);

    UtilisateurDto findByEmail(String email);

    UtilisateurDto changerMotDePasse(ChangerMotDePasseUtilisateurDto dto);

}

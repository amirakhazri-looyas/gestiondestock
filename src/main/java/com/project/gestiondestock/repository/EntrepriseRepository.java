package com.project.gestiondestock.repository;

import com.project.gestiondestock.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepository  extends JpaRepository<Entreprise,Integer> {
}

package com.project.gestiondestock.dto;

import com.project.gestiondestock.model.LigneCommandeFournisseur;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LigneCommandeFournisseurDto {
    private Integer id;
    private ArticleDto article;
    private CommandeFournisseurDto commandeFournisseur;
    private BigDecimal quantite;
    private BigDecimal prixUnitaire;

    public static LigneCommandeFournisseurDto fromEntity(LigneCommandeFournisseur ligneCommandeFournisseur){
        if (ligneCommandeFournisseur == null){
            return null;
        }
        return LigneCommandeFournisseurDto.builder()
                .id(ligneCommandeFournisseur.getId())
                .quantite(ligneCommandeFournisseur.getQuantite())
                .prixUnitaire(ligneCommandeFournisseur.getPrixUnitaire())
                .build();
    }

    public static LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDto ligneCommandeFournisseurDto){
        if (ligneCommandeFournisseurDto == null){
            return null;
        }
        LigneCommandeFournisseur ligneCommandeFournisseur = new LigneCommandeFournisseur();
        ligneCommandeFournisseur.setId(ligneCommandeFournisseurDto.getId());
        ligneCommandeFournisseur.setQuantite(ligneCommandeFournisseurDto.getQuantite());
        ligneCommandeFournisseur.setPrixUnitaire(ligneCommandeFournisseurDto.getPrixUnitaire());
        return ligneCommandeFournisseur;
    }
}

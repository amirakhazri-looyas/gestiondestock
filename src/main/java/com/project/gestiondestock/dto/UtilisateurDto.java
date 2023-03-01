package com.project.gestiondestock.dto;

import com.project.gestiondestock.model.Utilisateur;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class UtilisateurDto {
    private Integer id;
    private String nom;
    private String prenom;
    private String email;
    private Instant dateDeNaissance;
    private String motDePasse;
    private AdresseDto adresse;
    private String photo;
    private EntrepriseDto entreprise;
    private List<RolesDto> roles;

    public static UtilisateurDto fromEntity(Utilisateur user){
        if (user == null){
            return null;
        }
        return UtilisateurDto.builder()
                .id(user.getId())
                .nom(user.getNom())
                .prenom(user.getPrenom())
                .email(user.getEmail())
                .dateDeNaissance(user.getDateDeNaissance())
                .motDePasse(user.getMotDePasse())
                .photo(user.getPhoto())
                .build();
    }
    public static Utilisateur toEntity(UtilisateurDto userDto){
        if (userDto == null){
            return null;
        }
        Utilisateur user = new Utilisateur();
        user.setId(userDto.getId());
        user.setNom(userDto.getNom());
        user.setPrenom(userDto.getPrenom());
        user.setEmail(userDto.getEmail());
        user.setDateDeNaissance(userDto.getDateDeNaissance());
        user.setMotDePasse(userDto.getMotDePasse());
        user.setPhoto(userDto.getPhoto());
        return user;
    }
}

package com.project.gestiondestock.services.auth;

import com.project.gestiondestock.dto.UtilisateurDto;
import com.project.gestiondestock.exception.EntityNotFoundException;
import com.project.gestiondestock.exception.ErrorCodes;
import com.project.gestiondestock.model.Utilisateur;
import com.project.gestiondestock.model.auth.ExtendedUser;
import com.project.gestiondestock.repository.UtilisateurRepository;
import com.project.gestiondestock.services.IUtilisateurService;
import com.project.gestiondestock.services.impl.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {
    @Autowired
    private UtilisateurService service;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UtilisateurDto utilisateur = service.findByEmail(email);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        utilisateur.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleName())));

        return new ExtendedUser(utilisateur.getEmail(), utilisateur.getMotDePasse(), utilisateur.getEntreprise().getId(), authorities);

    }





   /* @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Utilisateur utilisateur = repository.findByEmail(email).orElseThrow(
               () -> new EntityNotFoundException("Email inexistant", ErrorCodes.UTILISATEUR_NOT_FOUND)
       );
        return new User(utilisateur.getEmail(), utilisateur.getMotDePasse(), Collections.emptyList());*/

        /*UtilisateurDto utilisateur = service.findByEmail(email);

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        utilisateur.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleName())));

        return new ExtendedUser(utilisateur.getEmail(), utilisateur.getMoteDePasse(), utilisateur.getEntreprise().getId(), authorities);*/
}

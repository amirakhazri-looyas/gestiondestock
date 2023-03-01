package com.project.gestiondestock.validator;

import com.project.gestiondestock.dto.CommandeClientDto;
import com.project.gestiondestock.dto.LigneCommandeClientDto;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeClientValidator {

    //TO DO to be implemented, if faut verifier que la liste des articles n'est pas null
    public static List<String> validate(LigneCommandeClientDto articleDto) {
        List<String> errors = new ArrayList<>();
        return errors;
    }
}

package com.project.gestiondestock.controller.api;

import com.project.gestiondestock.dto.ArticleDto;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static com.project.gestiondestock.utils.Constants.APP_ROOT;


@Api(APP_ROOT+ "/articles")
public interface ArticleApi {

    // consumes & produces: on va consommer un JSON et et on va produire un JSON
    @PostMapping(value = APP_ROOT+ "/articles/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un Article", notes = "Ajouter/Modifier Article", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code=200,message = "l'article cree/modifie avec succes"),
            @ApiResponse(code=400,message = "l'article n'est pas valide")
    })
    ArticleDto save(@RequestBody ArticleDto dto); // pour la deserialization de l'objet

    @GetMapping(value = APP_ROOT+ "/articles/{idArticle}",  produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Chercher un Article par id", notes = "chercher Article par son id", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code=200,message = "l'article a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun Article n'est trouvé avec l'Id fourni")
    })
    ArticleDto findById(@PathVariable("idArticle") Integer id);

    @GetMapping(value = APP_ROOT+ "/articles/{codeArticle}",  produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Chercher un Article par CODE", notes = "chercher Article par son CODE", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code=200,message = "l'article a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun Article n'est trouvé avec le CODE fourni")
    })
    ArticleDto findByCodeArticle(@PathVariable("codeArticle") String codeArticle);

    @GetMapping(value = APP_ROOT+ "/articles/all",  produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recupérer la liste des Articles", notes = "chercher et Renvoie la liste des articles", responseContainer= "List<ArticleDto>")
    @ApiResponses(value = {@ApiResponse(code=200,message = "Liste des Artilces/ Liste Vide")})
    List<ArticleDto> findAll();

    @DeleteMapping(value = APP_ROOT+ "/articles/delete/{idArticle}" )
    @ApiOperation(value = "Supprimer un Article par son id", notes = "Supprimer un Article par son id", response = ArticleDto.class)
    @ApiResponses(value = {@ApiResponse(code=200,message = "l'article a ete suprime")})
    void delete(@PathVariable("idArticle") Integer id);

}

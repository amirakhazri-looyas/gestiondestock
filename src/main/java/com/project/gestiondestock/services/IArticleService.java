package com.project.gestiondestock.services;

import com.project.gestiondestock.dto.ArticleDto;

import java.util.List;

public interface IArticleService {

    ArticleDto save(ArticleDto dto);
    ArticleDto findById(Integer id);
    ArticleDto findByCodeArticle(String codeArticle);
    List<ArticleDto> findAll();
    List<ArticleDto> findAllArticleByIdCategory(Integer idCategory);
    void delete(Integer id);
}

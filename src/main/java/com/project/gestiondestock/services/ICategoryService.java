package com.project.gestiondestock.services;

import com.project.gestiondestock.dto.ArticleDto;
import com.project.gestiondestock.dto.CategoryDto;

import java.util.List;

public interface ICategoryService {

    CategoryDto save(CategoryDto dto);
    CategoryDto findById(Integer id);
    CategoryDto findByCode(String code);
    List<CategoryDto> findAll();
    void delete(Integer id);

}


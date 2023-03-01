package com.project.gestiondestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.gestiondestock.model.Category;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoryDto {
    private Integer id;
    private String codeCategory;
    private String designation;
    private Integer idEntreprise;
    @JsonIgnore
    private List<ArticleDto> articles;

    //Mapping
    public static CategoryDto fromEntity(Category category) {
        if(category == null) {
            return null;
            //Throw an exception
        }
        return CategoryDto.builder()
                .id(category.getId())
                .codeCategory(category.getCodeCategory())
                .designation(category.getDesignation())
                .idEntreprise(category.get)
                .build();// la méthode build va construire un objet de type CategoryDto
    }

    public static Category toEntity(CategoryDto categoryDto){
        if (categoryDto == null){
            return null;
            //Throw an exception
        }
       Category category = new Category();
        category.setId(categoryDto.getId());
        category.setCodeCategory(categoryDto.getCodeCategory());
        category.setDesignation(categoryDto.getDesignation());
        return category;


    }
}

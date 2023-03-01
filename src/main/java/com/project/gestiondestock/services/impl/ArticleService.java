package com.project.gestiondestock.services.impl;

import com.project.gestiondestock.model.Article;
import com.project.gestiondestock.dto.ArticleDto;
import com.project.gestiondestock.exception.EntityNotFoundException;
import com.project.gestiondestock.exception.ErrorCodes;
import com.project.gestiondestock.exception.InvalidEntityException;
import com.project.gestiondestock.repository.ArticleRepository;
import com.project.gestiondestock.services.IArticleService;
import com.project.gestiondestock.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleService implements IArticleService {
    private ArticleRepository articleRepository;
    @Autowired
    public ArticleService (ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDto save(ArticleDto dto) {
        List<String> errors = ArticleValidator.validate(dto);
        if (!errors.isEmpty()){
           log.error("Article Invalid! {}",dto);
           throw new InvalidEntityException("", ErrorCodes.ARTICLE_NOT_VALID,errors);
        }
        return ArticleDto.fromEntity(
                articleRepository.save(
                        ArticleDto.toEntity(dto)
                ));
    }

    @Override
    public ArticleDto findById(Integer id) {
        if (id == null){
            log.error("Article ID is null");
            return null;
        }
        Optional<Article> article = articleRepository.findById(id);
        ArticleDto dto = ArticleDto.fromEntity(article.get()); //parser le resultat
        return Optional.of(dto).orElseThrow(() ->
              new EntityNotFoundException("Aucun Article avec l'ID : "+id+" n'ete trouve dans la BDD", ErrorCodes.ARTICLE_NOT_FOUND) );
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        if (!StringUtils.hasLength(codeArticle)){
            log.error("Article CODE is null");
            return null;
        }
        Optional<Article> article = articleRepository.findByCodeArticle(codeArticle);
        ArticleDto dto = ArticleDto.fromEntity(article.get()); //parser le resultat
        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun Article avec le Code : "+codeArticle+" n'ete trouve dans la BDD",
                        ErrorCodes.ARTICLE_NOT_FOUND)
        );
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleDto> findAllArticleByIdCategory(Integer idCategory) {
        return articleRepository.findAllByCategoryId(idCategory).stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Article ID is null");
            return;
        }
        articleRepository.deleteById(id);
    }
}
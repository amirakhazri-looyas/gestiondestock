package com.project.gestiondestock.repository;

import com.project.gestiondestock.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.expression.spel.ast.OpPlus;

import java.util.Optional;

public interface CategoryRepository  extends JpaRepository<Category,Integer> {

 Optional<Category> findCategoryByCodeCategory(String code);
}

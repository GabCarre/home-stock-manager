package com.gabriel.homestockmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.homestockmanager.model.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
}

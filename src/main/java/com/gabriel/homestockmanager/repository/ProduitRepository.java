package com.gabriel.homestockmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.homestockmanager.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {
}

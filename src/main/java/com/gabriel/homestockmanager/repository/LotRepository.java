package com.gabriel.homestockmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.homestockmanager.model.Lot;

public interface LotRepository extends JpaRepository<Lot, Integer> {
}
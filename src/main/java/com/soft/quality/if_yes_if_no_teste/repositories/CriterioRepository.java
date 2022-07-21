package com.soft.quality.if_yes_if_no_teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soft.quality.if_yes_if_no_teste.domais.Criterio;

@Repository
public interface CriterioRepository extends JpaRepository<Criterio, Integer> {

}

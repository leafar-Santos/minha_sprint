package com.soft.quality.if_yes_if_no_teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soft.quality.if_yes_if_no_teste.domais.Cenario;

@Repository
public interface CenarioRepository extends JpaRepository<Cenario, Integer> {

}

package com.soft.quality.if_yes_if_no_teste;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.soft.quality.if_yes_if_no_teste.domais.Cenario;
import com.soft.quality.if_yes_if_no_teste.domais.Criterio;
import com.soft.quality.if_yes_if_no_teste.domais.Historia;
import com.soft.quality.if_yes_if_no_teste.domais.Sprint;
import com.soft.quality.if_yes_if_no_teste.enums.ResultadoTeste;
import com.soft.quality.if_yes_if_no_teste.repositories.CenarioRepository;
import com.soft.quality.if_yes_if_no_teste.repositories.CriterioRepository;
import com.soft.quality.if_yes_if_no_teste.repositories.HistoriaRepository;
import com.soft.quality.if_yes_if_no_teste.repositories.SprintRepository;

@SpringBootApplication
public class IfYesIfNoTesteApplication implements CommandLineRunner {

	@Autowired
	private SprintRepository sprintRepository;

	@Autowired
	private HistoriaRepository historiaRepository;

	@Autowired
	private CriterioRepository criterioRepository;

	@Autowired
	private CenarioRepository cenarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(IfYesIfNoTesteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Date now = new Date();
		Sprint sprint1 = new Sprint(null,"Título da Sprint",now, now, "Sprint 0");
		Sprint sprint2 = new Sprint(null,"Título da Sprint2",now, now, "Sprint 1");

	
		Historia historia1 = new Historia(null, "Tela de Login", sprint1);
		sprint1.setHistoria(Arrays.asList(historia1));

		Criterio criterio1 = new Criterio(null, "Deve Acessar a tela de Login", historia1);
		historia1.setCriterioAceite(Arrays.asList(criterio1));

		Cenario cenario1 = new Cenario(null, criterio1, "Acessar Tela login", "Não há precondições",
				"Não há massa de dados", "Não há  critérios especiais", "Android", "Aqui vai uma imagem",
				ResultadoTeste.APROVADO, "Teste completo");

		criterio1.setCenariosTeste(Arrays.asList(cenario1));

		sprintRepository.saveAll(Arrays.asList(sprint1, sprint2));
		

		historiaRepository.saveAll(Arrays.asList(historia1));
		criterioRepository.saveAll(Arrays.asList(criterio1));
		cenarioRepository.saveAll(Arrays.asList(cenario1));

	}

}

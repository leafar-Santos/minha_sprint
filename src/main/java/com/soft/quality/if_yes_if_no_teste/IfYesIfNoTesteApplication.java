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
		Sprint sprint1 = new Sprint(null,"Sprint - 1",now, now, "Sprint para criar o ambiente de desenvolvimento.");
		Sprint sprint2 = new Sprint(null,"Sprint - 2",now, now, "Sprint para definir as regras de negócio do sistema.");
		Sprint sprint3 = new Sprint(null,"Sprint - 3",now, now, "Sprint para começar a desenvolver as features.");
	
		Historia historia1 = new Historia(null, "Criar ambiente de desenvolvimento", sprint1);
		sprint1.setHistoria(Arrays.asList(historia1));

		Historia historia2 = new Historia(null, "Definir as regras de negócio do sistema e das novas funcionalidades", sprint2);
		sprint2.setHistoria(Arrays.asList(historia2));
		
		Historia historia3 = new Historia(null, "Definir as regras de negócio do sistema e das novas funcionalidades", sprint3);
		sprint3.setHistoria(Arrays.asList(historia3));
		
		
		Criterio criterio1 = new Criterio(null, "Deve Acessar a tela de Login", historia1);
		historia1.setCriterioAceite(Arrays.asList(criterio1));
		
		Criterio criterio2 = new Criterio(null, "Deve Acessar a tela de Login", historia2);
		historia1.setCriterioAceite(Arrays.asList(criterio2));
		
		Criterio criterio3 = new Criterio(null, "Deve Acessar a tela de Login", historia3);
		historia1.setCriterioAceite(Arrays.asList(criterio3));

		Cenario cenario1 = new Cenario(null, criterio1, "Acessar Tela login", "Não há precondições",
				"Não há massa de dados", "Não há  critérios especiais", "Android", "Aqui vai uma imagem",
				ResultadoTeste.APROVADO, "Teste completo");

		Cenario cenario2 = new Cenario(null, criterio2, "Acessar Tela login", "Não há precondições",
				"Não há massa de dados", "Não há  critérios especiais", "Android", "Aqui vai uma imagem",
				ResultadoTeste.APROVADO, "Teste completo");
		
		Cenario cenario3 = new Cenario(null, criterio3, "Acessar Tela login", "Não há precondições",
				"Não há massa de dados", "Não há  critérios especiais", "Android", "Aqui vai uma imagem",
				ResultadoTeste.APROVADO, "Teste completo");
		
		
		criterio1.setCenariosTeste(Arrays.asList(cenario1,cenario1,cenario1));

		sprintRepository.saveAll(Arrays.asList(sprint1, sprint2, sprint3));
		

		historiaRepository.saveAll(Arrays.asList(historia1,historia2,historia3));
		criterioRepository.saveAll(Arrays.asList(criterio1,criterio2,criterio3));
		cenarioRepository.saveAll(Arrays.asList(cenario1,cenario2,cenario3));

	}

}

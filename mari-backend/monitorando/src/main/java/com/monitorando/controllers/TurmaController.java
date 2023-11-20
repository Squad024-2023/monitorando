package com.monitorando.controllers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.monitorando.model.Professor;
import com.monitorando.model.Turma;
import com.monitorando.services.ProfessorService;
import com.monitorando.services.TurmaService;

@Controller
@RequestMapping("/turmas")

public class TurmaController {
	@Autowired
	private TurmaService turmaService;
	@Autowired
	private ProfessorService professorService;

	@GetMapping
	public String listarTurmas(Model model) {
		List<Turma> turma = turmaService.getAllTurmas();
		model.addAttribute("turma", turma);
		return "ListarTurmas";

	}

	@GetMapping("novo")
	public String showForm(Model model) {
		Turma turma = new Turma();
		List<Professor> professores = professorService.getAllProfessores();
		model.addAttribute("turma", turma);
		model.addAttribute("professores", professores);
		return "turmaForm";

	}

	@PostMapping("/save")
	public String saveTurma(@ModelAttribute("turma") Turma turma, @RequestParam Set<Long> professores) {
		turma.setProfessores(
				professores.stream().map(professorService::getProfessorByProfMatricula).collect(Collectors.toSet()));
		turmaService.saveTurma(turma, professores);
		return "redirect:/turmas";
	}

	@GetMapping("/editar/{profMatricula}")
	public String ShowUpdateForm(@PathVariable("profMatricula") Long profMatricula, Model model) {
		Turma turma = turmaService.getTurmaById(profMatricula);
		model.addAttribute("turma", turma);
		model.addAttribute("professores", professorService.getAllProfessores());
		return "editarTurma";
	}

	@PostMapping("/editar/{profMatricula}")
	public String updateTurma(@PathVariable("ProfMatricula") Long profMatricula, @ModelAttribute("turma") Turma turma) {
		turmaService.updateTurma(profMatricula, turma);
		return "redirect:/turmas";
	}

	@GetMapping("/deletar/{profMatricula}")
	public String deleteTurma(@PathVariable Long profMatricula) {

		turmaService.deleteTurma(profMatricula);
		return ("redirect:/turmas");
	}

}
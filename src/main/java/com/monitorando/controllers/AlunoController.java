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
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.monitorando.model.Aluno;
import com.monitorando.model.Turma;
import com.monitorando.services.AlunoService;
import com.monitorando.services.TurmaService;

@Controller
@RequestMapping("/aluno")
public class AlunoController {
	
	 @Autowired
	    private AlunoService alunoService;

	    @Autowired
	    private TurmaService turmaService;
	
	@GetMapping
	public String listAluno(Model model) {
		List <Aluno> aluno = alunoService.getAllAluno();
		model.addAttribute("aluno", aluno);
		return "alunos";
	}
	
	@GetMapping("/novo")
    public String mostrarForm(Model model) {
		Aluno aluno = new Aluno();
	    List<Turma> turma = turmaService.getAllTurmas();
	    model.addAttribute("aluno", aluno);
	    model.addAttribute("turma", turma);
	    return "createAlu";
		
	}
	
	@PostMapping("/salvar")
	public String registrarAluno(@ModelAttribute("aluno") Aluno aluno, @RequestParam Set<Long> codTurma) {
	    aluno.setTurma(codTurma.stream()
	            .map(turmaService::getTurmaById)
	            .collect(Collectors.toSet()));
	    alunoService.saveAluno(aluno, codTurma);
	    return "redirect:/aluno";
	}
	
	@GetMapping("/editar/{alu_matricula}")
	public String editarForm(@PathVariable Long alu_matricula, Model model) {
	    Aluno aluno = alunoService.getAlunoById(alu_matricula);
	    model.addAttribute("aluno", aluno);
	    model.addAttribute("turma", turmaService.getAllTurmas());
	        return "updateAlu";
	}
	
	@PostMapping("/editar/{alu_matricula}")
	public String atualizarAluno(@PathVariable Long alu_matricula, @ModelAttribute Aluno aluno) {
	    Aluno alunoExistente = alunoService.getAlunoById(alu_matricula);

	    if (alunoExistente != null) {
	        alunoExistente.setAlu_nome(aluno.getAlu_nome());
	        alunoExistente.setAlu_telefone(aluno.getAlu_telefone());
	        alunoExistente.setAlu_email(aluno.getAlu_email());

	        alunoService.updateAluno(alu_matricula, alunoExistente);
	        return "redirect:/aluno";
	    } else {
	        return "redirect:/aluno";
	    }
	}
	
	 @GetMapping("/deletar/{alu_matricula}")
	    public String deleteAluno(@PathVariable Long alu_matricula) {
	        alunoService.deleteAluno(alu_matricula);
	        return "redirect:/aluno";
	}
	

}

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

import com.monitorando.model.Alunos;
import com.monitorando.model.Turmas;
import com.monitorando.services.AlunosService;
import com.monitorando.services.TurmasServices;

@Controller
@RequestMapping("/alunos")
public class AlunosController {
	
	 @Autowired
	    private AlunosService alunosService;

	    @Autowired
	    private TurmasServices turmasServices;
	
	@GetMapping
	public String listAlunos(Model model) {
		List <Alunos> alunos = alunosService.getAllAlunos();
		model.addAttribute("alunos", alunos);
		return "ListadeAlunos";
	}
	
	@GetMapping("/novo")
    public String mostrarForm(Model model) {
		Alunos alunos = new Alunos();
	    List<Turmas> turmas = turmasServices.getAllTurmas();
	    model.addAttribute("alunos", alunos);
	    model.addAttribute("turmas", turmas);
	    return "CadastrodeAlunos";
		
	}
	
	@PostMapping("/salvar")
	public String registrarAlunos(@ModelAttribute("alunos") Alunos alunos, @RequestParam Set<Integer> cod_turma) {
	    alunos.setTurmas(cod_turma.stream()
	            .map(turmasServices::getTurmasById)
	            .collect(Collectors.toSet()));
	    alunosService.saveAlunos(alunos, cod_turma);
	    return "redirect:/alunos";
	}
	
	@GetMapping("/editar/{alu_matricula}")
	public String editarForm(@PathVariable Integer alu_matricula, Model model) {
	    Alunos alunos = alunosService.getAlunosById(alu_matricula);
	    model.addAttribute("alunos", alunos);
	    model.addAttribute("turmas", turmasServices.getAllTurmas());
	        return "EditarAlunos";
	}
	
	@PostMapping("/editar/{alu_matricula}")
	public String atualizarAlunos(@PathVariable Integer alu_matricula, @ModelAttribute Alunos alunos) {
	    Alunos alunoExistente = alunosService.getAlunosById(alu_matricula);

	    if (alunoExistente != null) {
	        alunoExistente.setAlu_nome(alunos.getAlu_nome());
	        alunoExistente.setAlu_telefone(alunos.getAlu_telefone());
	        alunoExistente.setAlu_email(alunos.getAlu_email());

	        alunosService.updateAlunos(alu_matricula, alunoExistente);
	        return "redirect:/alunos";
	    } else {
	        return "redirect:/alunos";
	    }
	}
	
	 @GetMapping("/deletar/{alu_matricula}")
	    public String deleteAlunos(@PathVariable Integer alu_matricula) {
	        alunosService.deleteAlunos(alu_matricula);
	        return "redirect:/alunos";
	}
	

}

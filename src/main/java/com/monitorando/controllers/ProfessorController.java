package com.monitorando.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monitorando.model.Professor;
import com.monitorando.services.ProfessorService;

@Controller
@RequestMapping("/professores")
public class ProfessorController {
@Autowired
	private ProfessorService profService;

//Mostar todos os professores
@GetMapping
   public String listProfessor(Model model) {
	   List<Professor>professor = profService.getAllProfessores();
	   model.addAttribute("professores",professor);
	  return "professores";
   }
   //Adicionar um novo professor
   @GetMapping("novo")
   public String showFormAdd(Model model) {
	   Professor professor = new Professor();
	   model.addAttribute("professor", professor);
	   return "createProf";
   }
   //Formulario para a criação
   @PostMapping("/save")
   public String saveProfessor (@ModelAttribute("professor") Professor professor) {
	   profService.saveProfessor(professor);
	   return "redirect:/professores";
   }
   
	//Persistência da criação
   @GetMapping("/editar/{profMatricula}")
   public String showFormUpdate(@PathVariable Long profMatricula, Model model) {
	   Professor professor = profService.getProfessorByProfMatricula(profMatricula);
	   model.addAttribute("professor", professor);
	   return "updateProf";
   }
   
   //Formulário de Editar
   @PostMapping("/editar/{profMatricula}")
   public String updateProfessor(@PathVariable Long profMatricula, @ModelAttribute("professor")
   Professor professor) {
	  profService.updateProfessor(profMatricula, professor) ;
	  return "redirect:/professores";
   }
   //apagar um professor
   
   @GetMapping("deletar/{profMatricula}")
   public String deleteProf(@PathVariable Long profMatricula) {
	   profService.deleteProfessor(profMatricula);
	   return "redirect:/professores";
   }
   
}

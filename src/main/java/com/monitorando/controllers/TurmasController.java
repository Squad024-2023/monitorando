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

import com.monitorando.model.Turmas;
import com.monitorando.services.TurmasServices;

@Controller
@RequestMapping("/turmas")
public class TurmasController {

    @Autowired
    private TurmasServices turmasServices;

    @GetMapping
    public String listTurmas(Model model) {
        List<Turmas> turmas = turmasServices.getAllTurmas();
        model.addAttribute("turmas", turmas);
        return "ListadeTurmas";
    }

    @GetMapping("/novo")
    public String mostrarTurmas(Model model) {
        Turmas turmas = new Turmas();
        model.addAttribute("turmas", turmas);
        return "CadastrodeTurmas";
    }

    @PostMapping("/salvar")
    public String saveTurmas(@ModelAttribute("turmas") Turmas turmas) {
        turmasServices.saveTurmas(turmas);
        return "redirect:/turmas";
    }

    @GetMapping("/editar/{cod_turmas}")
    public String editarForm(@PathVariable Integer cod_turmas, Model model) {
        Turmas turmas = turmasServices.getTurmasById(cod_turmas);
        model.addAttribute("turmas", turmas);
        return "EditarTurmas";
    }

    @PostMapping("/editar/{cod_turmas}")
    public String atualizarTurma(@PathVariable Integer cod_turmas, @ModelAttribute Turmas turmasAtualizada) {
        turmasServices.updateTurmas(cod_turmas, turmasAtualizada);
        return "redirect:/turmas";
    }

    @GetMapping("/deletar/{cod_turma}")
    public String deletarTurmas(@PathVariable Integer cod_turmas) {
        turmasServices.deleteTurmas(cod_turmas);
        return "redirect:/turmas";
    }
}

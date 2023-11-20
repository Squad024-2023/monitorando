package com.monitorando.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Mari {
	@GetMapping("/ola")
	public String ola(Model model) {
		model.addAttribute("msg","Olá Mundo Spring" );
		return "ola";
		
	}

}

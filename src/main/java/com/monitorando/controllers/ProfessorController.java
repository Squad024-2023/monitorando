package com.monitorando.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monitorando.services.ProfessorService;

@Controller
@RequestMapping("/professores")
public class ProfessorController {
@Autowired
	private ProfessorService profService;
//public Spring
	
}

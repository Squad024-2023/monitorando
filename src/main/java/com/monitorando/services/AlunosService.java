package com.monitorando.services;

import java.util.List;
import java.util.Set;

import com.monitorando.model.Alunos;

public interface AlunosService {

		List<Alunos> getAllAlunos();
		
		Alunos getAlunosById(Integer alu_matricula);
		
		Alunos saveAlunos(Alunos alunos, Set<Integer> turmasCod);
		
		Alunos updateAlunos(Integer alu_matricula, Alunos alunosAtualizados);
		
		void deleteAlunos(Integer alu_matricula);
	
}

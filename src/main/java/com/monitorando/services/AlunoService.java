package com.monitorando.services;

import java.util.List;
import java.util.Set;

import com.monitorando.model.Aluno;

public interface AlunoService {
	
		List<Aluno> getAllAluno();
		
		Aluno getAlunoById(Long alu_matricula);
		
		Aluno saveAluno(Aluno aluno, Set<Long> codTurma);
		
		Aluno updateAluno(Long alu_matricula, Aluno alunoAtualizados);
		
		void deleteAluno(Long alu_matricula);
	
}

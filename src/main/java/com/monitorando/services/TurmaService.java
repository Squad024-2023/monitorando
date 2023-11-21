package com.monitorando.services;

import java.util.List;
import java.util.Set;

import com.monitorando.model.Turma;

public interface TurmaService {
	List<Turma> getAllTurmas();

	Turma getTurmaById(Long codTurma);

	Turma saveTurma(Turma turma, Set<Long> ProfMatricula);

	Turma updateTurma(Long codTurma, Turma turmaAtualizada);

	void deleteTurma(Long codTurma);
}

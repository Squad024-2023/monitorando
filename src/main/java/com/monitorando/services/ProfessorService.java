package com.monitorando.services;

import java.util.List;

import com.monitorando.model.Professor;

public interface ProfessorService {

	List<Professor> getAllProfessores();

	Professor getProfessorByProfMatricula(Long profMatricula);

	Professor saveProfessor(Professor professor);

	Professor updateProfessor(Long profMatricula, Professor profAtualizado);

	void deleteProfessor(Long profMatricula);

}

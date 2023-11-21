package com.monitorando.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.monitorando.model.Professor;
import com.monitorando.repositories.ProfessorRepository;
import com.monitorando.services.ProfessorService;

@Service
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired
	private ProfessorRepository profRepository;

	@Override
	public List<Professor> getAllProfessores() {

		return profRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Professor getProfessorByProfMatricula(Long profMatricula) {
		return profRepository.findById(profMatricula).orElse(null);
	}

	@Override
	@Transactional
	public Professor saveProfessor(Professor professor) {

		return profRepository.save(professor);
	}

	@Override
	public Professor updateProfessor(Long profMatricula, Professor profAtualizado) {
		Professor profExistente = profRepository.findById(profMatricula).orElse(null);
		if (profExistente != null) {
			profExistente.setProfNome(profAtualizado.getProfNome());
			profExistente.setProfEmail(profAtualizado.getProfEmail());
			profExistente.setProfTelefone(profAtualizado.getProfTelefone());
			profExistente.setProfSenha(profAtualizado.getProfSenha());
			return profRepository.save(profExistente);

		} else {
			throw new RuntimeException("Professor com a Matrícula " + profMatricula + " não foi encontrado!");
		}

	}

	@Override
	public void deleteProfessor(Long profMatricula) {
		profRepository.deleteById(profMatricula);

	}

}

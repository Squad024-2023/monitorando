package com.monitorando.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monitorando.model.Turmas;
import com.monitorando.repositories.TurmasRepository;
import com.monitorando.services.TurmasServices;

@Service
public class TurmasServiceImpl implements TurmasServices {

	@Autowired
	private TurmasRepository turmasRepository;

	@Override
	public List<Turmas> getAllTurmas() {
		return turmasRepository.findAll();
	}

	@Override
	public Turmas getTurmasById(Integer cod_turma) {
		return turmasRepository.findById(cod_turma).orElse(null);
	}

	@Override
	public Turmas saveTurmas(Turmas turmas) {
		return turmasRepository.save(turmas);
	}

	@Override
	public Turmas updateTurmas(Integer cod_turma, Turmas turmasAtualizadas) {
		Turmas turmasExistente = turmasRepository.findById(cod_turma).orElse(null);

		if (turmasExistente != null) {
			turmasExistente.setTurma_tipo(turmasAtualizadas.getTurma_tipo());
			turmasExistente.setTurma_data(turmasAtualizadas.getTurma_data());
			
			 turmasExistente.getAlunos().clear();
	         turmasExistente.getAlunos().addAll(turmasAtualizadas.getAlunos());


			return turmasRepository.save(turmasExistente);
		} else {
			throw new RuntimeException("NÃO ENCONTRAMOS O CÓDIGO DE TURMA " + cod_turma);
		}
	}

	@Override
	public void deleteTurmas(Integer cod_turma) {
		turmasRepository.deleteById(cod_turma);
	}
}

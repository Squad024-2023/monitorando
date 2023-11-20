package com.monitorando.servicesimpl;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.monitorando.model.Professor;
import com.monitorando.model.Turma;
import com.monitorando.repositories.TurmaRepository;
import com.monitorando.services.ProfessorService;
import com.monitorando.services.TurmaService;

@Service
public class TurmaServiceImpl implements TurmaService {

	@Autowired
	private TurmaRepository turmaRepository;
	@Autowired
	private ProfessorService professorService;

	@Override
	public List<Turma> getAllTurmas() {
		return turmaRepository.findAll();

	}

	@Override
	@Transactional(readOnly = true)
	public Turma getTurmaById(Long codTurma) {
		return turmaRepository.findById(codTurma).orElse(null);

	}

	@Override
	public Turma saveTurma(Turma turma, Set<Long> profMatricula) {
		Set<Professor> professores = profMatricula.stream().map(professorService::getProfessorByProfMatricula)
				.filter(Objects::nonNull).collect(Collectors.toSet());

		turma.setProfessores(professores);

		return turmaRepository.save(turma);
	}

	@Override
	public Turma updateTurma(Long codTurma, Turma turmaAtualizada) {
		Turma turmaExistente = turmaRepository.findById(codTurma).orElse(null);
		if (turmaExistente != null) {
			turmaExistente.setTipoTurma(turmaAtualizada.getTipoTurma());
			turmaExistente.setDataTurma(turmaAtualizada.getDataTurma());
			Set<Professor> profAtualizado = turmaAtualizada.getProfessores();
			for (Professor professor : profAtualizado) {
				professor.getTurmas().add(turmaExistente);

			}
			turmaExistente.setProfessores(profAtualizado);

			return turmaRepository.save(turmaExistente);
		} else {
			throw new RuntimeException("Turma com o Código Turma " + codTurma + "Não foi encontrada");
		}
	}

	@Override
	public void deleteTurma(Long codTurma) {
		turmaRepository.deleteById(codTurma);

	}

}

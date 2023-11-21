package com.monitorando.servicesimpl;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.monitorando.model.Aluno;
import com.monitorando.model.Turma;
import com.monitorando.repositories.AlunoRepository;
import com.monitorando.services.AlunoService;
import com.monitorando.services.TurmaService;


@Service
public class AlunoServiceImpl implements AlunoService{

	 @Autowired
	 private AlunoRepository alunoRepository;
	
	 @Autowired
	 private TurmaService turmaServices;
	
	 @Override
	  public List<Aluno> getAllAluno() {
	        return alunoRepository.findAll();
	    }
	 
	 @Override
	    @Transactional(readOnly = true)
	    public Aluno getAlunoById(Long alu_matricula) {
	        return alunoRepository.findById(alu_matricula).orElse(null);
	    }
	
	 @Override
	    public Aluno saveAluno(Aluno aluno, Set<Long> turmaCod) {
	        Set<Turma> turma = turmaCod.stream()
	                .map(turmaServices::getTurmaById)
	                .filter(Objects::nonNull)
	                .collect(Collectors.toSet());

	        aluno.setTurma(turma);

	        return alunoRepository.save(aluno);
	    }

	 @Override
	 public Aluno updateAluno(Long alu_matricula, Aluno alunoAtualizados) {
		    Aluno alunoExistente = alunoRepository.findById(alu_matricula).orElse(null);

		    if (alunoExistente != null) {
		        alunoExistente.setAlu_nome(alunoAtualizados.getAlu_nome());
		        alunoExistente.setAlu_telefone(alunoAtualizados.getAlu_telefone());
		        alunoExistente.setAlu_email(alunoAtualizados.getAlu_email());
		        alunoExistente.setAlu_senha(alunoAtualizados.getAlu_senha());

		        Set<Turma> turmaAtualizadas = alunoAtualizados.getTurma();
		        for (Turma turma : turmaAtualizadas) {
		            turma.getAluno().add(alunoExistente);
		        }

		        alunoExistente.getTurma().clear();
		        alunoExistente.getTurma().addAll(turmaAtualizadas);

		        return alunoRepository.save(alunoExistente);
		    } else {
		        throw new RuntimeException("ALUNO NÃO ENCONTRADO | CÓDIGO: " + alu_matricula);
		    }
		}

	 @Override
	    public void deleteAluno(Long alu_matricula) {
	        alunoRepository.deleteById(alu_matricula);
	    }

}

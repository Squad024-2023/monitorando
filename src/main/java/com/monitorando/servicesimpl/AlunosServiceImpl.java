package com.monitorando.servicesimpl;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.monitorando.model.Alunos;
import com.monitorando.model.Turmas;
import com.monitorando.repositories.AlunosRepository;
import com.monitorando.services.AlunosService;
import com.monitorando.services.TurmasServices;


@Service
public class AlunosServiceImpl implements AlunosService{

	 @Autowired
	 private AlunosRepository alunosRepository;
	
	 @Autowired
	 private TurmasServices turmasServices;
	
	 @Override
	  public List<Alunos> getAllAlunos() {
	        return alunosRepository.findAll();
	    }
	 
	 @Override
	    @Transactional(readOnly = true)
	    public Alunos getAlunosById(Integer alu_matricula) {
	        return alunosRepository.findById(alu_matricula).orElse(null);
	    }
	
	 @Override
	    public Alunos saveAlunos(Alunos alunos, Set<Integer> turmasCod) {
	        Set<Turmas> turmas = turmasCod.stream()
	                .map(turmasServices::getTurmasById)
	                .filter(Objects::nonNull)
	                .collect(Collectors.toSet());

	        alunos.setTurmas(turmas);

	        return alunosRepository.save(alunos);
	    }

	 @Override
	 public Alunos updateAlunos(Integer alu_matricula, Alunos alunosAtualizados) {
		    Alunos alunosExistente = alunosRepository.findById(alu_matricula).orElse(null);

		    if (alunosExistente != null) {
		        alunosExistente.setAlu_nome(alunosAtualizados.getAlu_nome());
		        alunosExistente.setAlu_telefone(alunosAtualizados.getAlu_telefone());
		        alunosExistente.setAlu_email(alunosAtualizados.getAlu_email());
		        alunosExistente.setAlu_senha(alunosAtualizados.getAlu_senha());

		        Set<Turmas> turmasAtualizadas = alunosAtualizados.getTurmas();
		        for (Turmas turma : turmasAtualizadas) {
		            turma.getAlunos().add(alunosExistente);
		        }

		        alunosExistente.getTurmas().clear();
		        alunosExistente.getTurmas().addAll(turmasAtualizadas);

		        return alunosRepository.save(alunosExistente);
		    } else {
		        throw new RuntimeException("ALUNO NÃO ENCONTRADO | CÓDIGO: " + alu_matricula);
		    }
		}

	 @Override
	    public void deleteAlunos(Integer alu_matricula) {
	        alunosRepository.deleteById(alu_matricula);
	    }

}

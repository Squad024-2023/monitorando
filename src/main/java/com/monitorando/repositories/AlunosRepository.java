package com.monitorando.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monitorando.model.Alunos;

@Repository
public interface AlunosRepository extends JpaRepository<Alunos, Integer>{
	
	

}

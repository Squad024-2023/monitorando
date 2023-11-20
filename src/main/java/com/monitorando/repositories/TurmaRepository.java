package com.monitorando.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monitorando.model.Turma;

@Repository
public interface  TurmaRepository extends JpaRepository<Turma,Long>{

}

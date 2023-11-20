package com.monitorando.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monitorando.model.Turmas;

@Repository
public interface TurmasRepository extends JpaRepository<Turmas, Integer>{

}

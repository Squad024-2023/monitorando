package com.monitorando.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monitorando.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}

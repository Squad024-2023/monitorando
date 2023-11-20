package com.monitorando.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name= "turmas")

public class Turmas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_turma;
	private String turma_tipo;
	private Date turma_data;
	
	@ManyToMany
	@JoinTable(
	    name = "alunos_turmas",
	    joinColumns = @JoinColumn(name = "cod_turma"),
	    inverseJoinColumns = @JoinColumn(name = "alu_matricula")
	)
	
	private Set<Alunos> alunos = new HashSet<>();
		
	public Integer getCod_turma() {
		return cod_turma;
	}

	public void setCod_turma(Integer cod_turma) {
		this.cod_turma = cod_turma;
	}

	public String getTurma_tipo() {
		return turma_tipo;
	}

	public void setTurma_tipo(String turma_tipo) {
		this.turma_tipo = turma_tipo;
	}

	public Date getTurma_data() {
		return turma_data;
	}

	public void setTurma_data(Date turma_data) {
		this.turma_data = turma_data;
	}

	public Turmas(Integer cod_turma, String turma_tipo, Date turma_data) {
		super();
		this.cod_turma = cod_turma;
		this.turma_tipo = turma_tipo;
		this.turma_data = turma_data;
	}
	
	public Turmas() {

	}

	public List<Alunos> getAlunos() {
	    return new ArrayList<>(alunos);
	}
	
}

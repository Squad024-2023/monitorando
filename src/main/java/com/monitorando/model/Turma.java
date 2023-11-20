package com.monitorando.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codTurma;
	private String tipoTurma;
	private LocalDateTime dataTurma;

	@ManyToMany
	@JoinTable(name = "turma_professor", joinColumns = @JoinColumn(name = "cod_turma"),
	inverseJoinColumns = @JoinColumn(name = "prof_matricula"))
	private Set<Professor> professores = new HashSet<>();

	public Turma() {
	}

	public Turma(Long codTurma, String tipoTurma, LocalDateTime dataTurma, Set<Professor> professores) {
		this.codTurma = codTurma;
		this.tipoTurma = tipoTurma;
		this.dataTurma = dataTurma;
		this.professores = professores;
	}

	public Long getCodTurma() {
		return codTurma;
	}

	public void setCodTurma(Long codTurma) {
		this.codTurma = codTurma;
	}

	public String getTipoTurma() {
		return tipoTurma;
	}

	public void setTipoTurma(String tipoTurma) {
		this.tipoTurma = tipoTurma;
	}

	public LocalDateTime getDataTurma() {
		return dataTurma;
	}

	public void setDataTurma(LocalDateTime dataTurma) {
		this.dataTurma = dataTurma;
	}

	public Set<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(Set<Professor> professores) {
		this.professores = professores;
	}
}

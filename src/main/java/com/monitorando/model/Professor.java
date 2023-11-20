package com.monitorando.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long profMatricula;
	@Column(nullable = false)
	private String profNome;
	@Column(nullable = false)
	private String profEmail;
	@Column(nullable = false)
	private String profTelefone;
	@Column(nullable = false)
	private String profSenha;

	@ManyToMany(mappedBy = "professores")
	private Set<Turma> turmas = new HashSet<>();

	public Professor() {

	}

	public Professor(Long profMatricula, String profNome) {
		this.profMatricula = profMatricula;
		this.profNome = profNome;
	}

	public Long getProfMatricula() {
		return profMatricula;
	}

	public void setProfMatricula(Long profMatricula) {
		this.profMatricula = profMatricula;
	}

	public String getProfNome() {
		return profNome;
	}

	public void setProfNome(String profNome) {
		this.profNome = profNome;
	}

	public Set<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(Set<Turma> turmas) {
		this.turmas = turmas;
	}

	public String getProfEmail() {
		return profEmail;
	}

	public void setProfEmail(String profEmail) {
		this.profEmail = profEmail;
	}

	public String getProfTelefone() {
		return profTelefone;
	}

	public void setProfTelefone(String profTelefone) {
		this.profTelefone = profTelefone;
	}

	public String getProfSenha() {
		return profSenha;
	}

	public void setProfSenha(String profSenha) {
		this.profSenha = profSenha;
	}
}

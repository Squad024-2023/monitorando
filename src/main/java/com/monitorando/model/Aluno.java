package com.monitorando.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name= "aluno")

public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long alu_matricula;
	
	private String alu_nome;
	private String alu_telefone;
	private String alu_email;
	private String alu_senha;
	
	@ManyToMany
    @JoinTable(name = "aluno_turma", 
               joinColumns = @JoinColumn(name = "alu_matricula"), 
               inverseJoinColumns = @JoinColumn(name = "cod_turma"))
    private Set<Turma> turma = new HashSet<>();
		
	public Long getAlu_matricula() {
		return alu_matricula;
	}
	public void setAlu_matricula(Long alu_matricula) {
		this.alu_matricula = alu_matricula;
	}
	public String getAlu_nome() {
		return alu_nome;
	}
	public void setAlu_nome(String alu_nome) {
		this.alu_nome = alu_nome;
	}
	public String getAlu_telefone() {
		return alu_telefone;
	}
	public void setAlu_telefone(String alu_telefone) {
		this.alu_telefone = alu_telefone;
	}
	public String getAlu_email() {
		return alu_email;
	}
	public void setAlu_email(String alu_email) {
		this.alu_email = alu_email;
	}
	
	public String getAlu_senha() {
		return alu_senha;
	}
	public void setAlu_senha(String alu_senha) {
		this.alu_senha = alu_senha;
	}
	
	public Aluno(Long alu_matricula, String alu_nome, String alu_telefone, String alu_email, String alu_senha) {
		super();
		this.alu_matricula = alu_matricula;
		this.alu_nome = alu_nome;
		this.alu_telefone = alu_telefone;
		this.alu_email = alu_email;
		this.alu_senha = alu_senha;
	}
	
	public Aluno() {
	}
	
	public Set<Turma> getTurma() {
		return turma;
	}
	public void setTurma(Set<Turma> turma) {
		this.turma = turma;
	}
}

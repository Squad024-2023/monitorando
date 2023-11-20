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
@Table(name= "alunos")

public class Alunos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer alu_matricula;
	
	private String alu_nome;
	private String alu_telefone;
	private String alu_email;
	private String alu_senha;
	
	@ManyToMany(mappedBy = "alunos")
	private Set<Turmas> turmas = new HashSet<>();
		
	public Integer getAlu_matricula() {
		return alu_matricula;
	}
	public void setAlu_matricula(Integer alu_matricula) {
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
	
	public Alunos(Integer alu_matricula, String alu_nome, String alu_telefone, String alu_email, String alu_senha) {
		super();
		this.alu_matricula = alu_matricula;
		this.alu_nome = alu_nome;
		this.alu_telefone = alu_telefone;
		this.alu_email = alu_email;
		this.alu_senha = alu_senha;
	}
	
	public Alunos() {
	}
	
	public Set<Turmas> getTurmas() {
		return turmas;
	}
	public void setTurmas(Set<Turmas> turmas) {
		this.turmas = turmas;
	}
}

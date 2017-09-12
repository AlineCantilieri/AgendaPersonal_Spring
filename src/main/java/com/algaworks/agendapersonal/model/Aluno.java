package com.algaworks.agendapersonal.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Aluno {	
	@Id
	@GeneratedValue
	@Column(name="id_aluno")
	private Long idAluno;
	
	@NotEmpty(message="Nome obrigatório!")
	private String nome;
	
	@NotNull(message="Idade obrigatória!")
	private int idade;
	
	@NotEmpty(message="Telefone obrigatória!")
	private String telefone;
	
	@OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
	private Set<Horario> horarios;

	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Set<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(Set<Horario> horarios) {
		this.horarios = horarios;
	}

	
}

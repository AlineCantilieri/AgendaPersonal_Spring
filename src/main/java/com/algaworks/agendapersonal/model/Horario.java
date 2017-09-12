package com.algaworks.agendapersonal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Horario {
	@Id
	@GeneratedValue
	private Long idHorario;
	
	@ManyToOne
	@JoinColumn(name = "id_aluno")
	@NotNull(message = "aluno obrigatório!")
	private Aluno aluno;
	
	@NotEmpty(message = "horario obrigatório!")
	private String horario;
	
	@NotEmpty(message = "professor obrigatório!")
	private String professor;

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public Long getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(Long id_horario) {
		this.idHorario = id_horario;
	}

	public Aluno getAluno() {
		return aluno;
	}
	public String getHorario(){
		return horario;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

}

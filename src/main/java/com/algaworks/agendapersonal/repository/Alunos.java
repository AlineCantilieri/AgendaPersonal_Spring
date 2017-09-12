package com.algaworks.agendapersonal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.agendapersonal.model.Aluno;


public interface Alunos extends JpaRepository<Aluno, Long> {

}

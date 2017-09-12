package com.algaworks.agendapersonal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.agendapersonal.model.Aluno;
import com.algaworks.agendapersonal.repository.Alunos;

@Controller
@RequestMapping("/alunos")
public class AlunoController {
	@Autowired
	private Alunos alunos;
	
	@GetMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("LisAluno");
		mv.addObject("alunos", alunos.findAll());
	    return mv;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("FrmAluno");
		mv.addObject(new Aluno());
		return mv;
	}
	
	@PostMapping("")
	public ModelAndView salvar(@Validated Aluno aluno, Errors erros, RedirectAttributes redirectAttributes){
		ModelAndView mv = new ModelAndView("FrmAluno");
		mv.addObject("alunos", alunos.findAll());
		if(erros.hasErrors()){
			return mv;
		}
		try {
			this.alunos.save(aluno);
			return new ModelAndView("redirect:alunos");
		} catch(Exception e) {return mv;}		
	}	

	@RequestMapping(value ="/excluir/{idAluno}")
	public String excluirAlunoByPathVariable(@PathVariable Long idAluno, HttpServletRequest request, 
			HttpServletResponse response) {
		this.alunos.delete(idAluno);
		//attributes.addFlashAttribute("mensagem", "Aluno excluído com sucesso!");
		return "redirect:/alunos";
	}
	
	@RequestMapping("/alterar/{idAluno}")
	public ModelAndView alterarBandaByPathVariable(@PathVariable Long idAluno, HttpServletRequest request, 
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("FrmAluno");
		mv.addObject("alunos", alunos.findAll());
		Aluno aluno = alunos.findOne(idAluno);
		mv.addObject(aluno);
		return mv;
	}
	
	@RequestMapping(value="{idAluno}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long idAluno, RedirectAttributes attributes) {
		alunos.delete(idAluno);
		attributes.addFlashAttribute("mensagem", "Aluno excluído com sucesso!");
		return "redirect:/alunos";
	}
}

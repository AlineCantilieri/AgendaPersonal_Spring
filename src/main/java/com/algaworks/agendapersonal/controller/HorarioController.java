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

import com.algaworks.agendapersonal.model.Horario;
import com.algaworks.agendapersonal.repository.Horarios;

@Controller
@RequestMapping("/horarios")
public class HorarioController {
	@Autowired
	private Horarios horarios;
		
	@GetMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("LisHorario");
		mv.addObject("horarios", horarios.findAll());
	    return mv;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("FrmHorario");
		mv.addObject(new Horario());		
		return mv;
	}
	
	@PostMapping("")
	public String salvar(@Validated Horario horario, Errors erros, RedirectAttributes redirectAttributes) {
		if(erros.hasErrors()){
			return "FrmHorario";
		}
			this.horarios.save(horario);
			redirectAttributes.addFlashAttribute("mensagem", "Horario salvo com sucesso!");
			return "redirect:/horarios";		
	}
	
	@RequestMapping(value ="/excluir/{idHorario}")
	public String excluirHorarioByPathVariable(@PathVariable Long idHorario, HttpServletRequest request, 
					HttpServletResponse response) {
		this.horarios.delete(idHorario);
		return "redirect:/horarios";
	}
	
	@RequestMapping("{idHorario}")
	public ModelAndView alterarHorarioByPathVariable(@PathVariable("idHorario") Long idHorario, HttpServletRequest request, 
			HttpServletResponse response, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView("FrmHorario");
		Horario horario = horarios.findOne(idHorario);
		mv.addObject(horario);
		return mv;
	}
	
	@RequestMapping(value="{idHorario}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long idHorario, RedirectAttributes attributes) {
		horarios.delete(idHorario);
		attributes.addFlashAttribute("mensagem", "Horario excluído com sucesso!");
		return "redirect:/horarios";
	}
	
}
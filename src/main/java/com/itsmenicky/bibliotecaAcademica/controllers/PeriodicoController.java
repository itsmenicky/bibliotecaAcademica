package com.itsmenicky.bibliotecaAcademica.controllers;

import com.itsmenicky.bibliotecaAcademica.models.Periodico;
import com.itsmenicky.bibliotecaAcademica.repositories.PeriodicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PeriodicoController {
    @Autowired
    private PeriodicoRepository pr;

    //Chamando form de cadastro de periódicos
    @RequestMapping("periodico/cadastrar-periodico")
    public String cadastrarPeriodico(){
        return "periodico/formPeriodico";
    }

    //Cadastrando periodicos
    @RequestMapping(value = "periodico/cadastrar-periodico", method = RequestMethod.POST)
    public String cadastrarPeriodico(@Valid Periodico periodico, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
            return "redirect:/cadastrar-periodico";
        }

        pr.save(periodico);
        attributes.addFlashAttribute("mensagem", "Periódico cadastrado com sucesso!");
        return "redirect:/periodicos";
    }

    //Listar periodicos
    @RequestMapping("/periodicos")
    public ModelAndView listarLivros(){
        ModelAndView mv = new ModelAndView("/periodico/lista-periodicos");
        Iterable<Periodico> periodicos = pr.findAll();
        mv.addObject("periodicos", periodicos);
        return mv;
    }

    //Chamando tela para editar periódicos
    @RequestMapping("/editar-periodico")
    public ModelAndView editarPeriodico(long id){
        ModelAndView mv = new ModelAndView("/periodico/editar-periodico");
        Periodico periodico = pr.findById(id);
        mv.addObject("periodico", periodico);
        return mv;
    }

    //Editando informações de um periódico
    @RequestMapping(value = "/editar-periodico", method = RequestMethod.POST)
    public String editarPeriodico(@Valid Periodico periodico, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Revise os campos!");
            return "redirect:/editar-periodico";
        }
        pr.save(periodico);
        return "redirect:/periodico/" + periodico.getId();
    }

    //Mostrando detalhes do periódico
    @RequestMapping("periodico/{id}")
    public ModelAndView detalhesPeriodico(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("periodico/detalhes-periodico");
        Periodico periodico = pr.findById(id);
        mv.addObject("periodico", periodico);
        return mv;
    }

    //Deletando periódico
    @RequestMapping("/deletar-periodico")
    public String deletarPeriodico(long id){
        Periodico periodico = pr.findById(id);
        pr.delete(periodico);
        return "redirect:/periodicos";
    }
}

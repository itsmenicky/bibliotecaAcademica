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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
public class PeriodicoController {
    @Autowired
    private PeriodicoRepository pr;

    //Chamando form de cadastro de periódicos
    @RequestMapping("/cadastrar-periodico")
    public String cadastrarPeriodico(){
        return "periodico/form-periodico";
    }

    //Cadastrando periodicos
    @RequestMapping(value = "/cadastrar-periodico", method = RequestMethod.POST)
    public String cadastrarPeriodico(@Valid Periodico periodico, BindingResult result, RedirectAttributes attributes, @RequestParam("imagem") MultipartFile imagem){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem_erro", "Verifique os campos!");
            System.out.println("erro" + result.getAllErrors());
            return "redirect:/cadastrar-periodico";
        }

        try {
            if(!imagem.isEmpty()){
                periodico.setCapa_periodico(imagem.getBytes());
            }
        }catch (IOException e){
            attributes.addFlashAttribute("mensagem_erro", "Erro ao enviar imagem");
            System.out.println("erro imagem" + result.getAllErrors());
            return "redirect:/cadastrar-periodico";
        }

        pr.save(periodico);
        attributes.addFlashAttribute("mensagem", "Periódico cadastrado com sucesso!");
        return "redirect:/periodicos";
    }

    //Listar periodicos
    @RequestMapping("/periodicos")
    public ModelAndView listarLivros(){
        ModelAndView mv = new ModelAndView("/periodico/listar-periodicos");
        Iterable<Periodico> periodicos = pr.findAll();
        mv.addObject("periodicos", periodicos);
        return mv;
    }

    //Chamando tela para editar periódicos
    @RequestMapping("/editar-periodico/{id}")
    public ModelAndView editarPeriodico(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("/periodico/editar-periodico");
        Periodico periodico = pr.findById(id);
        mv.addObject("periodico", periodico);
        return mv;
    }

    //Editando informações de um periódico
    @RequestMapping(value = "/editar-periodico/{id}", method = RequestMethod.POST)
    public String editarPeriodico(@PathVariable("id") long id, @Valid Periodico periodico, BindingResult result, RedirectAttributes attributes, @RequestParam("imagem") MultipartFile imagem){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem_erro", "Revise os campos!");
            return "redirect:/editar-periodico";
        }

        Periodico currentPeriodico = pr.findById(id);

        currentPeriodico.setTitulo(periodico.getTitulo());
        currentPeriodico.setData_publicacao(periodico.getData_publicacao());

        if(!imagem.isEmpty()){
            try {
                currentPeriodico.setCapa_periodico(imagem.getBytes());
            }catch (IOException e){
                attributes.addFlashAttribute("mensagem_erro", "Erro ao carregar imagem do periódico");
                return "redirect:/periodicos";
            }
        }

        pr.save(currentPeriodico);
        attributes.addFlashAttribute("mensagem", "Periódico atualizado com sucesso!");
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
    @RequestMapping("/deletar-periodico/{id}")
    public String deletarPeriodico(@PathVariable("id") long id){
        Periodico periodico = pr.findById(id);
        pr.delete(periodico);
        return "redirect:/periodicos";
    }
}

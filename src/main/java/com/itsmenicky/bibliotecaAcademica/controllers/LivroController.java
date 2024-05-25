package com.itsmenicky.bibliotecaAcademica.controllers;
import com.itsmenicky.bibliotecaAcademica.models.Livro;
import com.itsmenicky.bibliotecaAcademica.repositories.LivroRepository;
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
public class LivroController {
    @Autowired
    private LivroRepository lr;

    @RequestMapping(value = "/cadastrar-livro", method = RequestMethod.GET)
    public String form(){
        return "livro/form-livro";
    }

    //Cadastrando livro
    @RequestMapping(value = "/cadastrar-livro", method = RequestMethod.POST)
    public String form(@Valid Livro livro, BindingResult result, @RequestParam("imagem") MultipartFile imagem, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Revise os campos!");
            return "redirect:/livros";
        }

        try {
            if(!imagem.isEmpty()){
                livro.setCapa_livro(imagem.getBytes());
            }
        }catch(IOException e){
            attributes.addFlashAttribute("mensagem", "Erro ao cadastrar imagem do livro");
            return "redirect:/cadastrar-livro";
        }

        lr.save(livro);
        attributes.addFlashAttribute("mensagem", "Livro cadastrado com sucesso!");
        return "redirect:/livros";
    }

    //Deletar livro
    @RequestMapping("/deletar-livro/{id}")
    public String deletar_livro(@PathVariable("id") long id){
        Livro livro = lr.findById(id);
        lr.delete(livro);
        return "redirect:/livros";
    }

    //Listar livros
    @RequestMapping("/livros")
    public ModelAndView listarLivros(){
        ModelAndView mv = new ModelAndView("livro/listar-livros");
        Iterable<Livro> livros = lr.findAll();
        mv.addObject("livros", livros);
        return mv;
    }

    //Método que chama a tela de edição de livro
    @RequestMapping("/editar-livro/{id}")
    public ModelAndView editarLivro(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("livro/editar-livro");
        Livro livro = lr.findById(id);
        mv.addObject("livro", livro);
        return mv;
    }

    //Método que realiza a atualização das informações do livro
    @RequestMapping(value = "/editar-livro/{id}", method = RequestMethod.POST)
    public String editarLivro(@PathVariable("id") long id, @RequestParam("imagem") MultipartFile imagem, @Valid Livro livro, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Revise os campos!");
            return "redirect:/editar-livro";
        }

        Livro currentLivro = lr.findById(id);

        currentLivro.setTítulo(livro.getTítulo());
        currentLivro.setEdicao(livro.getEdicao());
        currentLivro.setAutor(livro.getAutor());
        currentLivro.setSituacao(livro.getSituacao());
        currentLivro.setISBN(livro.getISBN());

        if(!imagem.isEmpty()){
            try {
                currentLivro.setCapa_livro(imagem.getBytes());
            }catch (IOException e){
                attributes.addFlashAttribute("mensagem", "Erro ao carregar imagem do livro");
                return "redirect:/livros";
            }
        }

        lr.save(currentLivro);
        attributes.addFlashAttribute("mensagem", "Livro atualizado com sucesso!");
        return "redirect:/livro/" + id;
    }

    //Mostrando detalhes do livro
    @RequestMapping("/livro/{id}")
    public ModelAndView detalhesLivro(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("livro/detalhes-livro");
        Livro livro = lr.findById(id);
        mv.addObject("livro", livro);
        return mv;
    }
}

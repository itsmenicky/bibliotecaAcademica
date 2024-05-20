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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LivroController {
    @Autowired
    private LivroRepository lr;

    @RequestMapping(value = "/cadastrar-livro", method = RequestMethod.GET)
    public String form(){
        return "livro/formLivro";
    }

    //Cadastrando livro
    @RequestMapping(value = "/cadastrar-livro", method = RequestMethod.POST)
    public String form(@Valid Livro livro, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Revise os campos!");
            return "redirect:/cadastrar-livro";
        }

        lr.save(livro);
        attributes.addFlashAttribute("mensagem", "Livro cadastrado com sucesso!");
        return "redirect:/livros";
    }

    //Deletar livro
    @RequestMapping("/deletar-livro")
    public String deletar_livro(long id){
        Livro livro = lr.findById(id);
        lr.delete(livro);
        return "redirect:/livros";
    }

    //Listar livros
    @RequestMapping("/livros")
    public ModelAndView listarLivros(){
        ModelAndView mv = new ModelAndView("vaga/listar-livros");
        Iterable<Livro> livros = lr.findAll();
        mv.addObject("livros", livros);
        return mv;
    }

    //Método que chama a tela de edição de livro
    @RequestMapping("/editar-livro")
    public ModelAndView editarLivro(long id){
        ModelAndView mv = new ModelAndView("vaga/editar-livro");
        Livro livro = lr.findById(id);
        mv.addObject("livro", livro);
        return mv;
    }

    //Método que realiza a atualização das informações do livro
    @RequestMapping(value = "/editar-livro", method = RequestMethod.POST)
    public String editarLivro(@Valid Livro livro, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Revise os campos!");
            return "redirect:/editar-livro";
        }
        lr.save(livro);
        long livroId = livro.getId();
        return "redirect:/livro/" + livroId;
    }

    //Mostrando detalhes do livro
    @RequestMapping("/livro/{id}")
    public ModelAndView detalhesLivro(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("vaga/detalhes-livro");
        Livro livro = lr.findById(id);
        mv.addObject("livro", livro);
        return mv;
    }
}

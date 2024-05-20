package com.itsmenicky.bibliotecaAcademica.controllers;

import com.itsmenicky.bibliotecaAcademica.models.Usuario;
import com.itsmenicky.bibliotecaAcademica.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioRepository ur;

    //Chamando form que cadastra usuários
    @RequestMapping(value="/cadastrarUsuario", method = RequestMethod.GET)
    public String form(){
        return "usuario/formUsuario";
    }

    //Cadastrando usuário
    @RequestMapping(value = "/cadastrarUsuario", method = RequestMethod.POST)
    public String form(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Revise os campos!");
            return "redirect:/cadastrarUsuario";
        }

        ur.save(usuario);
        attributes.addFlashAttribute("mensagem", "Usuário cadastrado com sucesso!");
        return "re";
    }

    //Deletando usuário
    @RequestMapping("/deletarUsuario")
    public String deletar_usuario(long id){
        Usuario usuario = ur.findById(id);
        ur.delete(usuario);
        return "redirect:/usuarios";
    }
}

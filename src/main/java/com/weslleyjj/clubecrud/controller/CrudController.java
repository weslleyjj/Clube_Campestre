package com.weslleyjj.clubecrud.controller;

import com.weslleyjj.clubecrud.model.Associado;
import com.weslleyjj.clubecrud.service.AssociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/")
public class CrudController {

    final AssociadoService associadoService;

    public CrudController(AssociadoService associadoService) {
        this.associadoService = associadoService;
    }

    @RequestMapping("/home")
    public ModelAndView visualizar(){
        ModelAndView modelAndView = new ModelAndView("home");

        modelAndView.addObject("associadosList", associadoService.findAllAssociados());
        modelAndView.addObject("newAssociado", new Associado());

        return modelAndView;
    }

    @RequestMapping("/cadastra")
    public ModelAndView cadastraAssociado(Associado associado){
        ModelAndView modelAndView = new ModelAndView(new RedirectView("/home", true));

        try{
            associadoService.cadastraAssociado(associado);
        }catch (Exception e){
            System.out.println(e);
        }
        return modelAndView;
    }

}

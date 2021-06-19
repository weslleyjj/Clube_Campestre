package com.weslleyjj.clubecrud.controller;

import com.weslleyjj.clubecrud.model.Associado;
import com.weslleyjj.clubecrud.service.AssociadoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Objects;

/**
 * @author Jodeilson Weslley
 * Controller geral básico do sistema
 */

@Controller
@RequestMapping("/")
public class CrudController {

    /**
     * Configuração para instanciar acesso ao service
     */
    final AssociadoService associadoService;
    public CrudController(AssociadoService associadoService) {
        this.associadoService = associadoService;
    }

    /**
     * Método para a página inicial contendo a lista com todos os associados
     *
     * @return Página inicial do sistema
     */
    @RequestMapping("/home")
    public ModelAndView visualizar(){
        ModelAndView modelAndView = new ModelAndView("home");
        List<Associado> associadoList = associadoService.findAllAssociados();
        modelAndView.addObject("associadosList", associadoList);
        modelAndView.addObject("totalRegistros", associadoList.size());
        modelAndView.addObject("newAssociado", new Associado());

        return modelAndView;
    }

    /**
     * Método para a salvar entidade no banco
     *
     * @return Página inicial após o salvamento com êxito
     */
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

    /**
     * Método para redirecionar para página de edição de associado
     * @return Página permitindo a edição de determinado associado
     */
    @RequestMapping("/edita/{id}")
    public ModelAndView editaAssociado(@PathVariable Integer id){
        ModelAndView modelAndView = null;

        try{
            Associado associado = associadoService.findById(id.longValue());
            if(Objects.isNull(associado)){
                modelAndView = new ModelAndView(new RedirectView("home", true));
            }else{
                modelAndView = new ModelAndView("editarAssociado");

                modelAndView.addObject("newAssociado", associado);

            }
        }catch (Exception e){
            System.out.println(e);
        }
        return modelAndView;
    }

    /**
     * Método para remoção de uma entidade do banco
     *
     * @return Página inicial do sistema após a remoção
     */
    @RequestMapping("/remover/{id}")
    public ModelAndView removerAssociado(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView(new RedirectView("home", true));

        try{
            associadoService.remover(id.longValue());
        }catch (Exception e){
            System.out.println(e);
        }

        return modelAndView;
    }


}

package com.weslleyjj.clubecrud.service;

import com.weslleyjj.clubecrud.model.Associado;
import com.weslleyjj.clubecrud.repository.AssociadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Jodeilson Weslley
 * Service de Associado
 */

@Service
public class AssociadoService {

    /**
     * Configuração para instanciar acesso ao repository
     */
    final AssociadoRepository associadoRepository;
    public AssociadoService(AssociadoRepository associadoRepository) {
        this.associadoRepository = associadoRepository;
    }

    /**
     * @return lista com todos os associados salvos no banco
     */
    public List<Associado> findAllAssociados(){
        return associadoRepository.findAll();
    }

    /**
     * Método para salvar uma nova entidade ou editar uma que já possua o id
     */
    public void cadastraAssociado(Associado associado){
        associadoRepository.save(associado);
    }

    /**
     * @return Associado a partir do ID caso exista no banco
     */
    public Associado findById(Long id){
        Optional<Associado> a = associadoRepository.findById(id);
        return a.orElse(null);
    }

    /**
     * Método para remover um Associado do sistema
     */
    public void remover(Long id){
        associadoRepository.deleteById(id);
    }
}

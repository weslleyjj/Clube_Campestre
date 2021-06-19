package com.weslleyjj.clubecrud.service;

import com.weslleyjj.clubecrud.model.Associado;
import com.weslleyjj.clubecrud.repository.AssociadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssociadoService {

    final AssociadoRepository associadoRepository;


    public AssociadoService(AssociadoRepository associadoRepository) {
        this.associadoRepository = associadoRepository;
    }

    public List<Associado> findAllAssociados(){
        return associadoRepository.findAll();
    }

    public void cadastraAssociado(Associado associado){
        associadoRepository.save(associado);
    }

}

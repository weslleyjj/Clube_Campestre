package com.weslleyjj.clubecrud.repository;

import com.weslleyjj.clubecrud.model.Associado;
import com.weslleyjj.clubecrud.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
}

package com.weslleyjj.clubecrud;

import com.weslleyjj.clubecrud.model.Associado;
import com.weslleyjj.clubecrud.model.Banco;
import com.weslleyjj.clubecrud.model.Contato;
import com.weslleyjj.clubecrud.model.Endereco;
import com.weslleyjj.clubecrud.repository.AssociadoRepository;
import com.weslleyjj.clubecrud.repository.BancoRepository;
import com.weslleyjj.clubecrud.repository.ContatoRepository;
import com.weslleyjj.clubecrud.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ClubeCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClubeCrudApplication.class, args);
	}

}

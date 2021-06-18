package com.weslleyjj.clubecrud.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "associado")
public class Associado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ASSOCIADO")
    @SequenceGenerator(name = "SEQ_ASSOCIADO", sequenceName = "id_seq_associado", allocationSize = 1)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_banco")
    private Banco banco;

    @OneToMany(mappedBy = "associado", targetEntity = Contato.class)
    private List<Contato> contatos;

    @Column
    private String rg;

    @Column
    private String cpf;

    @Column
    private String nome;

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public List<Contato> getContato() {
        return contatos;
    }

    public void setContato(List<Contato> contato) {
        this.contatos = contato;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

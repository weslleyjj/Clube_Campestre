package com.weslleyjj.clubecrud.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIO")
    @SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "id_seq_usuario", allocationSize = 1)
    private Long id;

    @Column
    @NotNull
    private String login;

    @Column
    @NotNull
    private String senha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

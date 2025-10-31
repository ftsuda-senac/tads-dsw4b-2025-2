package br.senac.tads.dsw.dadospessoais.security;

import org.springframework.security.core.GrantedAuthority;

public class Permissao implements GrantedAuthority{

    private String nome;

    public Permissao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getAuthority() {
        return this.nome;
    }

}

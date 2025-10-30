package br.senac.tads.dsw.dadospessoais;

import java.time.LocalDate;
import java.util.List;

import br.senac.tads.dsw.dadospessoais.validacao.SenhasIguais;
import br.senac.tads.dsw.dadospessoais.validacao.UsernameUnico;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class PessoaUpdateDto {

    @NotBlank
    @Size(max = 100)
    private String nome;

    @PastOrPresent
    private LocalDate dataNascimento;

    @NotBlank
    @Size(max = 100)
    @Email
    private String email;

    @Size(max = 20)
    private String telefone;

    @Size(min = 1)
    private List<@NotBlank String> interesses;

    public PessoaUpdateDto() {
    }

    public PessoaUpdateDto(String nome, LocalDate dataNascimento, String email, String telefone,
            List<String> interesses) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.interesses = interesses;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public List<String> getInteresses() {
        return interesses;
    }

    public void setInteresses(List<String> interesses) {
        this.interesses = interesses;
    }

}

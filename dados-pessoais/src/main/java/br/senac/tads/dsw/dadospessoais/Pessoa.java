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

@SenhasIguais
public class Pessoa {

    @NotBlank // @NotNull + @NotEmpty
    @Size(max = 64)
    @UsernameUnico
    private String username;

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

    @Size(min = 8)
    // Explicação da expressão regular abaixo em https://stackoverflow.com/a/18181478
    // Teste de regex online: https://regex101.com/
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W]).{8,}")
    private String senha;

    private String repeticaoSenha;

    @Size(min = 1)
    private List<@NotBlank String> interesses;

    public Pessoa() {
    }

    public Pessoa(String username, String nome, LocalDate dataNascimento, String email, String telefone, String senha,
            List<String> interesses) {
        this.username = username;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.repeticaoSenha = senha;
        this.interesses = interesses;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRepeticaoSenha() {
        return repeticaoSenha;
    }

    public void setRepeticaoSenha(String repeticaoSenha) {
        this.repeticaoSenha = repeticaoSenha;
    }

    public List<String> getInteresses() {
        return interesses;
    }

    public void setInteresses(List<String> interesses) {
        this.interesses = interesses;
    }

}

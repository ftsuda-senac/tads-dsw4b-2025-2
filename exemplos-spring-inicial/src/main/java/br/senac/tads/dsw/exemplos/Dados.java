package br.senac.tads.dsw.exemplos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.cglib.core.Local;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public record Dados(String nome, String email, LocalDateTime dataHoraAtual) {

}

/*
public class Dados {

    private final String nome;

    private final String email;

    private final LocalDateTime dataHoraAtual;

    public Dados(String nome, String email, LocalDateTime dataHoraAtual) {
        this.nome = nome;
        this.email = email;
        this.dataHoraAtual = dataHoraAtual;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getDataHoraAtual() {
        return dataHoraAtual;
    }
    
}
*/

/*
// Exemplo de uso do Lombok
@Getter
@Setter
@AllArgsConstructor
public class Dados {

    private String nome;

    private String email;

    private LocalDateTime dataHoraAtual;
}
*/
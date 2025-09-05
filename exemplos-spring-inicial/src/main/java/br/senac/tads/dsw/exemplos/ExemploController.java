package br.senac.tads.dsw.exemplos;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExemploController {

    private final GeradorSaida geradorSaida;

    public ExemploController(GeradorSaida geradorSaida) {
        this.geradorSaida = geradorSaida;
    }

    @GetMapping(produces = "application/json")
    public String gerarJson(
            @RequestParam("nome") String nome,
            @RequestParam("email") String email) {
        Dados dados = new Dados(nome, email, LocalDateTime.now());
        return geradorSaida.gerarSaida(dados);
    }
}
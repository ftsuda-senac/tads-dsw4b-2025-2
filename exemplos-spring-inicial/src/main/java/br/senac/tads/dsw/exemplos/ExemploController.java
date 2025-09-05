package br.senac.tads.dsw.exemplos;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExemploController {

    @GetMapping(produces = "application/json")
    public Dados gerarJson(
            @RequestParam("nome") String nome,
            @RequestParam("email") String email,
            @RequestParam("time") String time) {
        return new Dados(nome, email, time, "abcdq121", LocalDateTime.now());
    }
}
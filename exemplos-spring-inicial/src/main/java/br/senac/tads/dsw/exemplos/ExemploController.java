package br.senac.tads.dsw.exemplos;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExemploController {

    @Autowired
    private GeradorSaida geradorSaida;

    @GetMapping(produces = "application/json")
    @ResponseBody
    public String gerarJson(
            @RequestParam("nome") String nome,
            @RequestParam("email") String email) {
        Dados dados = new Dados(nome, email, LocalDateTime.now());
        return geradorSaida.gerarSaida(dados);
    }
}
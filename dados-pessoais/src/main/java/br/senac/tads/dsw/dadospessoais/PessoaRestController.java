package br.senac.tads.dsw.dadospessoais;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class PessoaRestController {

    @Autowired
    private PessoaService service;

    @GetMapping
    public List<Pessoa> findAll() {
        return service.findAll();
    }

    // @RequestParam("username") ==> @RequestParam(value = "username")

    @GetMapping("/apelido")
    public Pessoa findByUsernameRequestParam(
            @RequestParam(value= "username", defaultValue = "fulano") String username) {
        // if (username == null) {
        //     return service.findByUsername("fulano");
        // }
        return service.findByUsername(username);
    }

    @GetMapping("/{username}")
    public Pessoa findByUsername(@PathVariable("username") String u) {
        return service.findByUsername(u);
    }

}

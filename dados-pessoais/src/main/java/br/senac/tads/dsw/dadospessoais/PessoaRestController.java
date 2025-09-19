package br.senac.tads.dsw.dadospessoais;

import java.net.URI;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/pessoas")
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
        Pessoa p = service.findByUsername(u);
        if (p == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Usuário %s não encontrado".formatted(u));
        }
        return p;
    }

    @PostMapping
    public ResponseEntity<?> addNew(@RequestBody Pessoa pessoa) {
        Pessoa p = service.addNew(pessoa);
        URI location = ServletUriComponentsBuilder
            .fromCurrentRequestUri()
            .path("/{username}")
            .buildAndExpand(p.getUsername())
            .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{username}")
    public ResponseEntity<?> update(
            @PathVariable String username,
            @RequestBody Pessoa pessoa) {
        Pessoa p = service.findByUsername(username);
        if (p == null) {
            return ResponseEntity.notFound().build();
        }
        p = service.update(username, pessoa);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> delete(@PathVariable String username) {
        service.delete(username);
        return ResponseEntity.noContent().build();
    }

}

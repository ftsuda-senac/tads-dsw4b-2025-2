package br.senac.tads.dsw.dadospessoais;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    private Map<String, Pessoa> mapPessoas;

    public PessoaService() {
        mapPessoas = new HashMap<>();
        mapPessoas.put("fulano", new Pessoa("fulano", "Fulano da Silva", 
            LocalDate.parse("2000-10-20"), "fulano@email.com", "11 91234-1234",
            "Abcd1234", List.of("Java", "Spring Boot")));
        mapPessoas.put("ciclano", new Pessoa("ciclano", "Ciclano de Souza", 
            LocalDate.parse("1999-05-14"), "ciclano@email.com", "11 98765-8765",
            "Abcd1234", List.of("HTML", "CSS", "Javascript")));
        mapPessoas.put("beltrana", new Pessoa("beltrana", "Beltrana dos Santos", 
            LocalDate.parse("2001-02-23"), "beltrana@email.com", "11 91122-3344",
            "Abcd1234", List.of("Javascript", "Angular", "React")));
    }

    public List<Pessoa> findAll() {
        return new ArrayList<>(mapPessoas.values());
    }

    public Pessoa findByUsername(String username) {
        return mapPessoas.get(username);
    }

    public Pessoa addNew(Pessoa pessoa) {
        return null;
    }

    public Pessoa update(String username, Pessoa pessoa) {
        return null;
    }

    public void delete(String username) {

    }

}

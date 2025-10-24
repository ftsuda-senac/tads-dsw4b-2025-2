package br.senac.tads.dsw.dadospessoais;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senac.tads.dsw.dadospessoais.persistence.entities.InteresseEntity;
import br.senac.tads.dsw.dadospessoais.persistence.entities.PessoaEntity;
import br.senac.tads.dsw.dadospessoais.persistence.repository.PessoaRepository;

@Service
public class PessoaServiceJpaImpl implements PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

   private Pessoa toDto(PessoaEntity ent) {
        Pessoa dto = new Pessoa();
        dto.setUsername(ent.getUsername());
        dto.setNome(ent.getNome());
        dto.setDataNascimento(ent.getDataNascimento());
        dto.setEmail(ent.getEmail());
        dto.setTelefone(ent.getTelefone());
        List<String> interesses = new ArrayList<>();
        if (ent.getInteresses() != null) {
            for (InteresseEntity intEnt : ent.getInteresses()) {
                interesses.add(intEnt.getNome());
            }
        }
        dto.setInteresses(interesses);
        return dto;
    }

    @Override
    public List<Pessoa> findAll() {
        List<PessoaEntity> entities = pessoaRepository.findAll();
        List<Pessoa> resultado = new ArrayList<>();
        for (PessoaEntity ent : entities) {
            resultado.add(toDto(ent));
        }
        return resultado;
    }

    @Override
    public Pessoa findByUsername(String username) {
        Optional<PessoaEntity> optPessoa = pessoaRepository.findByUsername(username);
        if (optPessoa.isEmpty()) {
            // Pessoa não foi encontrada
            return null;
        }
        PessoaEntity ent = optPessoa.get();
        return toDto(ent);
    }

    @Override
    public Pessoa addNew(Pessoa dto) {
        PessoaEntity entity = new PessoaEntity();
        entity.setUsername(dto.getUsername());
        entity.setNome(dto.getNome());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setEmail(dto.getEmail());
        entity.setTelefone(dto.getTelefone());
        entity.setSenha(dto.getSenha());
        // TODO: Setar interesses
        pessoaRepository.save(entity);
        return dto;
    }

    @Override
    public Pessoa update(String username, Pessoa pessoa) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}

package br.senac.tads.dsw.dadospessoais;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.senac.tads.dsw.dadospessoais.persistence.entities.InteresseEntity;
import br.senac.tads.dsw.dadospessoais.persistence.entities.PessoaEntity;
import br.senac.tads.dsw.dadospessoais.persistence.repository.InteresseRepository;
import br.senac.tads.dsw.dadospessoais.persistence.repository.PessoaRepository;

@Service
public class PessoaServiceJpaImpl implements PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private InteresseRepository interesseRepository;

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
    @Transactional
    public Pessoa addNew(Pessoa dto) {
        PessoaEntity entity = new PessoaEntity();
        entity.setUsername(dto.getUsername());
        entity.setNome(dto.getNome());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setEmail(dto.getEmail());
        entity.setTelefone(dto.getTelefone());
        entity.setSenha(dto.getSenha());

        Set<InteresseEntity> interesses = new HashSet<>();
        for (String interesse : dto.getInteresses()) {
            Optional<InteresseEntity> optInteresse =
                interesseRepository.findByNomeIgnoreCase(interesse);
            if (optInteresse.isPresent()) {
                interesses.add(optInteresse.get());
            }
        }
        entity.setInteresses(interesses);
        pessoaRepository.save(entity);
        return dto;
    }

    @Override
    @Transactional
    public Pessoa update(String username, PessoaUpdateDto updateInput) {
        Optional<PessoaEntity> optPessoaEntity = pessoaRepository.findByUsername(username);
        if (optPessoaEntity.isEmpty()) {
            return null;
        }
        PessoaEntity pessoaEntity = optPessoaEntity.get();
        pessoaEntity.setNome(updateInput.getNome());
        pessoaEntity.setDataNascimento(updateInput.getDataNascimento());
        pessoaEntity.setEmail(updateInput.getEmail());
        pessoaEntity.setTelefone(updateInput.getTelefone());
        Set<InteresseEntity> interesses = new HashSet<>();
        for (String interesse : updateInput.getInteresses()) {
            Optional<InteresseEntity> optInteresse =
                interesseRepository.findByNomeIgnoreCase(interesse);
            if (optInteresse.isPresent()) {
                interesses.add(optInteresse.get());
            }
        }
        pessoaEntity.setInteresses(interesses);
        pessoaRepository.save(pessoaEntity);
        return toDto(pessoaEntity);
    }

    @Override
    @Transactional
    public void delete(String username) {
        Optional<PessoaEntity> optPessoa = pessoaRepository.findByUsername(username);
        if (optPessoa.isEmpty()) {
            return;
        }
        pessoaRepository.delete(optPessoa.get());
    }

}

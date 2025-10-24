package br.senac.tads.dsw.dadospessoais.validacao;

import org.springframework.beans.factory.annotation.Autowired;

import br.senac.tads.dsw.dadospessoais.PessoaService;
import br.senac.tads.dsw.dadospessoais.persistence.repository.PessoaRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UsernameUnicoValidator 
    implements ConstraintValidator<UsernameUnico, String> {
    
    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return (pessoaRepository.findByUsername(username).isEmpty());
    }

}

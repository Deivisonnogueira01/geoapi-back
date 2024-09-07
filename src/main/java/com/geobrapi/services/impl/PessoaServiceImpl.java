package com.geobrapi.services.impl;

import com.geobrapi.domain.Pessoa;
import com.geobrapi.repositories.PessoaRepository;
import com.geobrapi.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Pessoa criarUsuario(Pessoa pessoa) {
        // Criptografa a senha antes de salvar
        pessoa.setSenha(bCryptPasswordEncoder.encode(pessoa.getSenha()));
        return pessoaRepository.save(pessoa);
    }
}

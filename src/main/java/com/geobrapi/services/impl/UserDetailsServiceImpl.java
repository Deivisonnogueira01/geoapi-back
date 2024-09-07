package com.geobrapi.services.impl;

import com.geobrapi.domain.Pessoa;
import com.geobrapi.repositories.PessoaRepository;
import com.geobrapi.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private PessoaRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Pessoa> user = repository.findByUsername(username);
        if (user.isPresent()) {
            return new UserSS(user.get().getId(), user.get().getUsername(), user.get().getSenha());
        }
        throw new UsernameNotFoundException(username);
    }
}

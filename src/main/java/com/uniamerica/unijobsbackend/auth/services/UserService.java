package com.uniamerica.unijobsbackend.auth.services;

import com.uniamerica.unijobsbackend.auth.model.UserSecurity;
import com.uniamerica.unijobsbackend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var user = usuarioRepository
                .findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(email));

        return new UserSecurity(user);

    }
}

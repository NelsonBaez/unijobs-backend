package com.uniamerica.unijobsbackend.services;

import com.uniamerica.unijobsbackend.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "Não foi encotrado um Usuario com esse Email: %s";
    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(email).orElseThrow(
            () -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email))
        );
    }
}

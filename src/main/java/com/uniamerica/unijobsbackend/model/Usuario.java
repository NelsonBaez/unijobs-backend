package com.uniamerica.unijobsbackend.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Usuario implements Serializable, UserDetails {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    private String email;
    @NotNull
    private String senha;
    @NotNull
    @Column(nullable = false)
    private String nome;
    @NotNull
    private String celular;
    @NotNull
    private  String ra;

    @OneToOne
    private TipoUsuario tipoUsuario;

    public Usuario(String email, String senha, String nome, String celular, String ra, TipoUsuario tipoUsuario) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.celular = celular;
        this.ra = ra;
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(tipoUsuario.getNome());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

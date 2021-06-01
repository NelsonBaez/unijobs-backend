package com.uniamerica.unijobsbackend.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;


@RequiredArgsConstructor
@Entity
@Data
public class TipoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;
}

package com.uniamerica.unijobsbackend.controllers;

import com.uniamerica.unijobsbackend.dto.input.NovoServicoDTO;
import com.uniamerica.unijobsbackend.dto.ServicoDTO;
import com.uniamerica.unijobsbackend.models.Servico;
import com.uniamerica.unijobsbackend.services.ServicoService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@OpenAPIDefinition
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/servicos")
public class ServicoController {
    
    private final ServicoService servicoService;

    public ServicoController(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    @GetMapping
    public ResponseEntity<Page<ServicoDTO>> findAll(Pageable pageable){
        return ResponseEntity.ok(servicoService.findAll(pageable));
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<ServicoDTO> find(@PathVariable("id") Integer id){
        return ResponseEntity.ok(servicoService.find(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ServicoDTO> cadastrar(@Valid @RequestBody NovoServicoDTO servico){
        return ResponseEntity.ok(servicoService.store(servico.converteModelo()));
    }

    @PutMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ServicoDTO> atualizar(@Valid @RequestBody NovoServicoDTO novoServico, @PathVariable("id") Integer id){
        return ResponseEntity.ok(servicoService.update( id, novoServico.converteModelo()));
    }

    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deletar(@PathVariable("id") Integer id){
        return servicoService.destroy(id);
    }
}

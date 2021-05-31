package com.uniamerica.unijobsbackend.tipoProduto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class TipoProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Código da Categoria do Produto.")
    private Integer id_tipo_produto;

    @NotBlank(message = "O nome é obrigatório.")
    @ApiModelProperty(value = "Nome da Categoria do Produto.")
    private String nome;

    @NotBlank(message = "A descrição é obrigatória.")
    @ApiModelProperty(value = "Descrição da Categoria do Produto.")
    private String descricao;
}

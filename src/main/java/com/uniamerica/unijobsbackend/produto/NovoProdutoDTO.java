package com.uniamerica.unijobsbackend.produto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class NovoProdutoDTO {
    @NotBlank(message = "O Título é obrigatório.")
    @ApiModelProperty(value = "Título do Produto")
    private String titulo;

    @NotBlank(message = "A descrição é obrigatória.")
    @ApiModelProperty(value = "Descrição do Produto")
    private String descricao;

    @NotNull(message = "O preço é obrigatório.")
    @ApiModelProperty(value = "Preço do Produto")
    private Double preco;

    @NotBlank(message = "A miniatura é obrigatória.")
    @ApiModelProperty(value = "Imagem do Produto")
    private String miniatura;

    @NotNull(message = "O prazo é obrigatório.")
    @ApiModelProperty(value = "Prazo do Produto")
    private Integer prazo;

    public Produto converteModelo(){
        Produto produto = new Produto();
        produto.setTitulo(titulo);
        produto.setDescricao(descricao);
        produto.setPreco(preco);
        produto.setMiniatura(miniatura);
        produto.setPrazo(prazo);

        return produto;
    }
}

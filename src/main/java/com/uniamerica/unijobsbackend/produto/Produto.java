package com.uniamerica.unijobsbackend.produto;

import com.uniamerica.unijobsbackend.tipoProduto.TipoProduto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Código do Produto")
    private Integer id_produto;

    @NotBlank(message = "O Título é obrigatório.")
    @ApiModelProperty(value = "Título do Produto")
    private String titulo;

    @NotBlank(message = "A descrição é obrigatória.")
    @ApiModelProperty(value = "Descrição do Produto")
    private String descricao;

    @ApiModelProperty(value = "Preço do Produto")
    private Double preco;

    @ApiModelProperty(value = "Imagem do Produto")
    private String miniatura;

    @ApiModelProperty(value = "Status do Produto")
    private Boolean ativo;

    @ApiModelProperty(value = "Prazo do Produto")
    private Integer prazo;

    @ApiModelProperty(value = "Código do Usuário")
    private Integer id_usuario;

    @ManyToOne
    @JoinColumn(name = "id_tipo_produto")
    @ApiModelProperty(value = "Código da Categoria do Produto.")
    private TipoProduto tipoProduto;
}

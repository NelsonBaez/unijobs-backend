package com.uniamerica.unijobsbackend.produto;

import com.uniamerica.unijobsbackend.tipoProduto.TipoProduto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_produto;

    private String titulo;

    private String descricao;

    private Double preco;

    private String miniatura;

    private Boolean ativo;

    private Integer prazo;

    @ApiModelProperty(value = "Código do Usuário")
    private Integer id_usuario;

    @ManyToOne
    @JoinColumn(name = "id_tipo_produto")
    @ApiModelProperty(value = "Código da Categoria do Produto.")
    private TipoProduto tipoProduto;
}

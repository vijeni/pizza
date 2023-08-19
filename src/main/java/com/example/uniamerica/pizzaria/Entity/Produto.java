package com.example.uniamerica.pizzaria.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table (name="produtos", schema = "public")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    @Column(name="id", unique = true)
    private Long id;

    @Getter @Setter
    @Column(name="nome", nullable = false, length = 20)
    private String nome;

    @Getter @Setter
    @Column(name = "valor_unitario", nullable = false)
    private Double valorUnitario;

    @Getter @Setter
    @Column(name="quantidade", nullable = false)
    private Integer quantidadeEstoque;

    @Getter @Setter
    @Column(name = "descricao", length = 50)
    private String descricao;

    @Getter @Setter
    @JsonIgnore
    @ManyToMany(mappedBy = "produtos")
    private List<Pedido> pedidos;
}

package com.ProductManager.Api.Domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Audited;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.util.UUID;

//anotaão para indentificar que é uma entidade
@Entity
@Builder
@Getter
@Setter
//criar construtores cheios
@AllArgsConstructor
//criar construtor vazios
@NoArgsConstructor
@Table (name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    //anotacao do hibernate para destinguir o tipo
    @JdbcTypeCode(SqlTypes.VARCHAR)
    // coluna do db
    @Column (name = "id")
    private UUID uuid;

    //nao deixar a coluna do db vazia
    @NotNull
    @Column (name = "nome")
    private  String nome;

    @Column (name = "descricao")
    private String descricao;

    @Column (name = "preco")
    private BigDecimal preco;

    @Column (name = "quantidade")
    private int quantidade;


}

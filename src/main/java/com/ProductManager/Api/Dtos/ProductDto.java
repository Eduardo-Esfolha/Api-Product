package com.ProductManager.Api.Dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import java.math.BigDecimal;

@Builder

public record ProductDto (@NotNull String nome, String descricao, BigDecimal preco, int quantidade) {

}
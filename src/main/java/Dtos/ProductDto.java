package Dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder

public record ProductDto (@NotNull String nome, BigDecimal preco, String descricao, int quantidade) {

}
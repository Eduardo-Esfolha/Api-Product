package com.ProductManager.Api.Service;

import com.ProductManager.Api.Domain.Product;
import com.ProductManager.Api.Dtos.ProductDto;
import com.ProductManager.Api.Repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

//declerando que é um service
@RequiredArgsConstructor
@Service
public class ProductService {

    //persistindo no banco de dados
    private final ProductRepository repository;

    //metodo de criar o produto
    public Product createProduct(ProductDto dto){

        Product product = Product.builder().
                nome(dto.nome()).
                descricao(dto.descricao()).
                preco(dto.preco()).
                quantidade(dto.quantidade()).
                build();
        //salva no banco o propduto criado
        return repository.save(product);
    }

    //busca por id
    public Product findByUuid(UUID uuid){
      return repository.findById(uuid)
               .orElseThrow(()-> new RuntimeException("id não encontrado"));
    }

    //lista os produto
    public List<Product> readProducts (){
        return repository.findAll();
    }

    //atualiza um produto
    public Product updateProduct(ProductDto productDto, UUID uuid) {
        Product produto = repository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));

        produto.setNome(productDto.nome());
        produto.setDescricao(productDto.descricao());
        produto.setPreco(productDto.preco());
        produto.setQuantidade(productDto.quantidade());

        return repository.save(produto);
    }

    //deleta um produto pelo id
    public void deleteProduct (UUID uuid){
        if (!repository.existsById(uuid)){
            throw new EntityNotFoundException("Produto não encontrado");
        }
        //deletando o produto encontrado
        repository.deleteById(uuid);
    }





}

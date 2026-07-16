package com.ProductManager.Api.Controller;

import com.ProductManager.Api.Domain.Product;
import com.ProductManager.Api.Dtos.ProductDto;
import com.ProductManager.Api.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/produto")
@RequiredArgsConstructor
@RestController
public class ProductController {
    private final ProductService service;

    @PostMapping
    public ResponseEntity  <Product> postProduct (@Valid @RequestBody ProductDto productDto){
        Product produto = service.createProduct(productDto);
        return ResponseEntity.ok().body(produto);
    }

    @GetMapping
    public ResponseEntity<List<Product>> readProduct () {
        List<Product> listaprodutos = service.readProducts();
        return ResponseEntity.ok(listaprodutos);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Product> findByUuid(@Valid @PathVariable UUID uuid) {
       Product produtofind =  service.findByUuid(uuid);
        return ResponseEntity.ok(produtofind);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity <Void> deleteProduto (@Valid @PathVariable UUID uuid){
        service.deleteProduct(uuid);
        return ResponseEntity.noContent().build();
    }


}


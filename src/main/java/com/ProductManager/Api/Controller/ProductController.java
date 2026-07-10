package com.ProductManager.Api.Controller;

import com.ProductManager.Api.Domain.Product;
import com.ProductManager.Api.Dtos.ProductDto;
import com.ProductManager.Api.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/produto")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @PostMapping
    public ResponseEntity  <Product> postProduct (@Valid @RequestBody ProductDto productDto){
        Product produto = service.createProduct(productDto);
        return ResponseEntity.ok().body(produto);

    }
    @GetMapping
    public ResponseEntity<List<Product>> readProduct (){
        List<Product> listaprodutos = service.readProducts();
        return ResponseEntity.ok(listaprodutos);

    }


}

package com.ProductManager.Api.Repository;

import com.ProductManager.Api.Domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
// a classe exstende de JpaRepository para criar o crud passando o id e o objeto manipulado
public interface ProductRepository extends JpaRepository <Product,  UUID >{


}

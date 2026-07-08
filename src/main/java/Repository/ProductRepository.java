package Repository;

import Domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
// a classe exstende de JpaRepository para criar o crud passando o id e o objeto manipulado
public interface ProductRepository extends JpaRepository <Product,  UUID >{


}

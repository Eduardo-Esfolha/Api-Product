package Service;

import Domain.Product;
import Dtos.ProductDto;
import Repository.ProductRepository;
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
    private final ProductRepository prodcutRepository;

    //metodo de criar o produto
    public Product CreateProduct(ProductDto dto){

        Product product = Product.builder().
                nome(dto.nome()).
                descricao(dto.descricao()).
                preco(dto.preco()).
                quantidade(dto.quantidade()).
                build();
        //salva no banco o propduto criado
        return prodcutRepository.save(product);

    }

    //busca por id
    public Product FindByUuid(UUID uuid){
      return prodcutRepository.findById(uuid)
               .orElseThrow(()-> new RuntimeException("id não encontrado"));
    }

    //lista os produto
    public List<Product> ReadProducts (){
        return prodcutRepository.findAll();
    }

    //atualzia um produto
    public Product UpdateProduct (ProductDto productDto, UUID uuid){
        if (!prodcutRepository.existsById(uuid)){
            throw new EntityNotFoundException("Produto não encontrado");
        }
        //instancia o produto
        Product produto = new Product();

        //seta os novos valores
        produto.setUuid(uuid);
        produto.setNome(productDto.nome());
        produto.setDescricao(productDto.descricao());
        produto.setPreco(productDto.preco());
        produto.setQuantidade(productDto.quantidade());
        //salva o produtoatualizado no db
        return prodcutRepository.save(produto);

    }

    //deleta um produto pelo id
    public void DeletProduct (UUID uuid){
        if (!prodcutRepository.existsById(uuid)){
            throw new EntityNotFoundException("Produto não encontrado");
        }
        //deletando o produto encontrado
        prodcutRepository.deleteById(uuid);
    }



}

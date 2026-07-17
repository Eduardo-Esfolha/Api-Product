# Api-Product

API REST para gerenciamento de produtos, desenvolvida com **Spring Boot** e **Java**. Permite criar, listar, buscar por UUID e remover produtos, com persistência em banco de dados **MySQL**.

## 🚀 Tecnologias

- Java 25
- Spring Boot 4.1.0
  - Spring Web (MVC)
  - Spring Data JPA
  - Spring Validation
  - Spring RestClient
  - Spring DevTools
- MySQL (via `mysql-connector-j`)
- Lombok
- Maven

## 📁 Estrutura do projeto

```
src/main/java/com/ProductManager/Api
├── ApiApplication.java        # Classe principal (entry point)
├── Controller
│   └── ProductController.java # Endpoints REST
├── Service
│   └── ProductService.java    # Regras de negócio
├── Repository
│   └── ProductRepository.java # Acesso ao banco (JPA)
├── Domain
│   └── Product.java           # Entidade JPA
├── Dtos
│   └── ProductDto.java        # DTO de entrada (record)
└── Utils
    └── GenerateValue.java     # Utilitário de geração de UUID
```

## ⚙️ Configuração

O projeto usa MySQL como banco de dados. Configure a conexão em `src/main/resources/application.properties`:

```properties
spring.application.name=Api
spring.datasource.url=jdbc:mysql://localhost:3306/produtos
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
```

> Ajuste `username`, `password` e a URL de acordo com o seu ambiente. O schema `produtos` é criado/atualizado automaticamente pelo Hibernate (`ddl-auto=update`).

### Pré-requisitos

- JDK 25
- MySQL em execução localmente (ou ajustar a URL para outro host)
- Maven (ou usar o wrapper `mvnw` incluso no projeto)

### Rodando o projeto

```bash
# Linux/Mac
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run
```

A aplicação sobe por padrão em `http://localhost:8080`.

## 📌 Endpoints

Base path: `/produto`

| Método | Rota            | Descrição                          |
|--------|------------------|-------------------------------------|
| POST   | `/produto`       | Cria um novo produto                |
| GET    | `/produto`       | Lista todos os produtos             |
| GET    | `/produto/{uuid}`| Busca um produto pelo UUID          |
| DELETE | `/produto/{uuid}`| Remove um produto pelo UUID         |

### Exemplo de payload (POST `/produto`)

```json
{
  "nome": "Teclado mecânico",
  "descricao": "Teclado mecânico RGB switch red",
  "preco": 249.90,
  "quantidade": 10
}
```

### Modelo de dados (`Product`)

| Campo       | Tipo       | Observações                  |
|-------------|------------|-------------------------------|
| uuid        | UUID       | Gerado automaticamente (PK)  |
| nome        | String     | Obrigatório                  |
| descricao   | String     | Opcional                     |
| preco       | BigDecimal | Opcional                     |
| quantidade  | int        | Opcional                     |

## 🧪 Testes

O projeto já inclui as dependências de teste do Spring Boot (`starter-test` para JPA, RestClient e WebMVC). Para rodar os testes:

```bash
./mvnw test
```

## 📝 Licença

Este projeto ainda não possui uma licença definida.

# TODOList

Este é um backend simples para uma aplicação TODOList, desenvolvido com Spring Boot, Spring Security, PostgreSQL, H2, Liquibase e Docker para implantação.

## Tecnologias Utilizadas

- **Spring Boot** - Framework principal para desenvolvimento da aplicação
- **Spring Security** - Implementação de autenticação e autorização
- **PostgreSQL** - Banco de dados relacional para produção
- **H2 Database** - Banco de dados em memória para testes
- **Liquibase** - Controle de versão do banco de dados
- **Docker** - Containerização da aplicação

## Configuração e Execução

### 1. H2 database
Por padrão o perfil de execução é 'dev' onde a aplicação está configurada para ser excutada com o h2 database

### 2. Outros perfis
Crie uma arquivo .env ou adicione as variáveis de ambiente ao contexto de execução
```
SERVER_PORT=
POSTGRES_HOST=
POSTGRES_HOST=
APPLICATION_DATABASE=
POSTGRES_USERNAME=
POSTGRES_PASSWORD=
```

### 3. Executar com Docker
Crie a imagem Docker e execute o container:

```sh
$ docker build -t todolist-backend .
$ docker run -p 8080:8080 todolist-backend
```

### 4. Executar Localmente

Caso prefira rodar sem Docker, utilize:

```sh
$ mvn spring-boot:run
```

Para rodar os testes utilizando H2:

```sh
$ mvn test
```

## Migração do Banco de Dados

O Liquibase gerencia as migrações do banco automaticamente. Para aplicar as migrações manualmente, use:

```sh
$ mvn liquibase:update
```

## Autenticação

A API utiliza JWT para autenticação. Para acessar os endpoints protegidos, primeiro faça login e utilize o token JWT retornado no cabeçalho `Authorization`.

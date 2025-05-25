# Authentication and authorization application

Project developed with the objective of deepening knowledge in Java using the Spring Boot framework, applying the principles of clean architecture and exploring communication between microservices.

Image below shows the database modeling

![./assets/diagram-erb.png](./assets/diagram-erb.png)

## Setup

1. Baixe o repositório `git clone git@github.com:mr4torr/saas-auth.git`;
2. Faça uma copia do arquivo `.env.example` e coloque-o como `.env`;
3. Crie um arquivo docker-compose.yml, esse arquivo serve para rodar o banco de dados.
4. Rode `docker compose up -d` e depois rode `./mvnw spring-boot:run`
5. Acesse `http://localhost:8080/swagger-ui.html` para visualizar a documentação da API. 

```yml
version: '3.8'
services:
  postgres:
    image: postgres:17.4-alpine
    container_name: saas_db
    environment:
      POSTGRES_DB: saas
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: root
    ports:
      - "5432:5432"
    restart: always
```
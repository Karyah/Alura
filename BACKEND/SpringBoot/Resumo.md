# Projeto Voll Med API

## Sobre o projeto:
Neste repositório, upei a API que desenvolvi seguindo as aulas da formação Java e Spring Boot, da **Alura**. 

Este projeto é uma API RESTful focada em simular um ambiente hospitalar ou clínico, onde pacientes podem agendar consultas. Nela, é realizada o CRUD de Medicos, Pacientes e Consultas, e apenas usuários autenticados conseguem acessar as endpoints. Diversas regras de negócios devem ser aplicadas ao tentar agendar ou cancelar uma consulta, por exemplo: 
* As consultas só podem ser agendadas nos horários em que a clínica está aberta.
* As consultas só podem ser agendadas ou canceladas com horário de antecendencia.

Entre várias outras validações que podem ser vistas no package [.../model/consulta/validacoes](https://github.com/Karyah/Alura/tree/master/BACKEND/SpringBoot/apiAlura/src/main/java/med/voll/apiAlura/model/consulta/validacoes).

## O que eu aprendi:
Nessa formação da Alura, aprendi a criar uma API RESTful do início ao fim, seguindo boas práticas o programação, e utilizando diversas tecnologias e princípios. Alguns destaques são:

* Boas práticas de desenvolvimento
   * Aprendi a lidar com o Protocolo HTTP, devolvendo sempre o melhor status e corpo HTTP para cada requisição.
   * Aprendi a lidar com erros e devolver o melhor status HTTP para a situação.
     
* Aplicação de princípios SOLID
   * Durante as aulas, aprendi e apliquei bastante o Single Responsiblity Principle, toda a estrutura do projeto foi baseada nele, e toda classe tem sua única responsabilidade.
  
* Autenticação com Spring Security usando JWT
  
* Documentação com Swagger e OpenAPI
  
* Testes de unidade com JUnit
  
* Build da aplicação e preparação para deploy

## Módulos do Sping Boot:

* Spring Data JPA
* Spring Security
* Spring Boot Dev Tools
* Flyway Migrations
* Lombok
* MySql Driver
* Validation

  

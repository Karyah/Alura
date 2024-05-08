# Spring initializr

* Usaremos o Maven como ferramenta de gereciamento de ferramentas e build.

* Linguagem Java (é um curso de java!)

* Versão do Spring Boot. Usaremos a 3.0.4

* Group: med.voll -> nome da empresa fictícia

* Packaging: como o curso será empacotado, no caso, .jar.

* A versão do java deve ser a última versão do Java LTS. No caso, usaremos a 17.

## Adicionando Dependências:
* Spring Boot Dev Tools
Módulo do Spring Boot para não ter que reiniciar a aplicação a cada alteração do código.
* Lombok
Gera métodos verbosos como setters and getters, construtores, toString, etc.
* Spring Web
Trabalhando com API.

Essas serão as primeiras mais essenciais que acrescentaremos em nossa aplicação.

# Programando

* Devemos forçar a atualização do Maven, para que tenhamos certeza que todas as dependencias foram baixadas corretamente.

* Static:
    * Onde fica as coisas estáticas, css, js, imagens

* Templates:
    * Páginas HTML

* Applications.properties
    * Configurações de nosso projeto.

## Detalhes importante

* @RestController
* @RequestMapping("/")
* @GetMapping

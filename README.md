<h1 align="center"> Fiap Agro </h1>
<p align="center"> Projeto criado para o módulo "INTEGRATIONS & DEVELOPMENT TOOLS" - FIAP - Grupo 1 <br></p>


###  Integrantes do Grupo<Br>
341417 - LUCAS GOIANA MALICIA<br>
340887 - VINICIUS BEZERRA LIMA<br>

# Como utilizar o backend

### Pré-requisitos

- Java 11
- Gradle
- Mysql
- Spring Framework
- Postman

# As Tecnologias Escolhidas

Para esse projeto foi criado uma api feita com Spring Framework e Mysql e RabbitMQ e também duas telas de front-end, sendo que, a primeira(index.html) representa o drone e a segunda(index2.hmtl) responsável por realizar a pesquisa da última localização do drone e mostra-lá em um mapa<br> <b>Link da Documentação da Api Google Maps:</b> <a href ="https://developers.google.com/maps/documentation/javascript/marker-clustering">Clique aqui</a> .

O Software foi dividido em duas camadas:

- *api* - Contempla a API em Java(Spring Framework) com Mysql e RabbitMQ, Cadastro da Última Localização do Drone e o gerenciamento de Filas ultilizando o RabbitMQ.
  <br>

- *front* - Contempla o Front-End(HTML 5, CSS 3, JS, Jquery, Ajax) o qual integramos com a api.

> <b>Obs.:</b> Deixamos no diretório ./fiapAgro.postman_collection.json a collection com todos os endpoints criado, para consumir a fila será necessária executar o endpoint consumerRabbitMQ.

Utilizamos o Spring Framework pelo ganho de produtividade e pela otimização de tempo.
Vale destacar o Spring Data JPA, que nos permite utilizar todas as annotations, facilitando a conexão da aplicação java com qualquer banco de dados sem a necessidade de criar os
métodos de CRUD.

Por fim, escolhemos a estrutura MVC para os projetos, visando separação, estruturação e melhor legibilidade nos códigos.

### Diagrama - FiapAgro

![modelo logico](https://lucasgoiana.com/integrations/Screenshot.png)

  # Video Explicativo: <a href="https://youtu.be/aEgayyYPdsA">Clique Aqui</a>

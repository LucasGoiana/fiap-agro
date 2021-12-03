
<h1 align="center"> Fiap Hemocentro </h1>
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

# Link GitHub

<a href="https://github.com/LucasGoiana/fiapBlood">Cliquei aqui</a>

# Tema
Todos os dias acontecem centenas de acidentes, cirurgias e queimaduras violentas que exigem transfusão, assim como os portadores de hemofilia, leucemia e anemias, para ajudar as pessoas nessas condições a encontrar os Hemocentros mais próximos, nós desenvolvemos o Sistema de Banco de Sangue - FiapBlood, o software mais completo para o Gerenciamento e Busca de Hemocentros.

# As Tecnologias Escolhidas

Para esse projeto foi criado uma api com base nas opções de escolhas que nos foram dadas, por isso, optamos por fazer o nosso software com Spring Framework e Mysql. 

O Software foi dividido em duas camadas:

- **FiapBlood** - Contempla a API de Java(Spring Framework) com Mysql, Cadastro de Banco de Sangue, Controle de Estoque e Tipo de Sangue, além disso, esse projeto contém integrações com o <a href="https://viacep.com.br/" target="_blank">VIACep</a> e <a href="https://nominatim.openstreetmap.org/ui/search.html" target="_blank">Nominatim</a>.<br>
  <b>Link Documentação Api: </b> <a href="https://fiap-blood.herokuapp.com/swagger-ui.html#/" target="_blank">Clique aqui </a>

- **bancodesanguefront** - Contempla o Front-End(HTML 5, CSS 3, JS, Jquery, Ajax) que informando somente o CEP busca a lista de Hemocentros/Bancos de Sangue cadastrados mais próximos.<br>
<b>Link Front: </b> <a href="https://lucasgoiana.com/bancodesanguefront/" target="_blank">Clique aqui </a>

Cada diretório mencionado acima possui uma documentação no arquivo readme.md, essa documentação possui o passo a passo da execução do aplicativo e a documentação da api.

> <b>Obs.:</b> O Nominatim não contempla todos os ceps. Isso pode ocasionar falhas nas buscas durante o testes, para resolver isso, por favor, utilize mais de um cep em seus testes.

Utilizamos o Spring Framework pelo ganho de produtividade e pela otimização de tempo.
Vale destacar o Spring Data JPA, que nos permite utilizar todas as annotations, facilitando a conexão da aplicação java com qualquer banco de dados sem a necessidade de criar os
métodos de CRUD.

Por fim, escolhemos a estrutura MVC para os projetos, visando separação, estruturação e melhor legibilidade nos códigos.

### Modelo Logico - FiapBlood

![modelo logico](https://lucasgoiana.com/rest/bd.png)

> O modelo logico se encontra no arquivo "FiapBlood_MER.pdf"

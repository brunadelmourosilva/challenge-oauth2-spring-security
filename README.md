# challenge-oauth2-spring-security

Ideias:

-> microservice 1: criar um server authorization com spring

-> microservice 2: criar um microservice(CRUD com MongoDB) -> permite requisições com token

-> microservice 3: criar um app client que envia requisições para o microservice 2 e obtém/cadastra infos.

* implementar social login, além do login padrão por ouath já configurado.
  * fazer pag. personalizada para inserir o login por social login
  * testar para ver se loga com outras contas, além da conta que já uso o client id/secret
  
* no final, terá um projeto com spring security oauth + social login.

* ver doc oficial do spring com oauth para obter mais detlhes.

* ao final, criar uma imagem para cada ms e comunicá-las pelo docker compose, utilizando as portas da própria aplicação.

Contexto:

cadastrar/obter músicas

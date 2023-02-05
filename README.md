# challenge-oauth2-spring-security

Ideias:

-> microservice 1: criar um server authorization com spring

-> microservice 2: criar um microservice(CRUD com MongoDB) -> permite requisições com token
 -> conecta-se com meu authorization server criado(ms 1) e com o login social externo.

-> microservice 3: criar um app client que envia requisições para o microservice 2 e obtém/cadastra infos.

* implementar social login, além do login padrão por ouath já configurado.
  * fazer pag. personalizada para inserir o login por social login
  * testar para ver se loga com outras contas, além da conta que já uso o client id/secret
  
* no final, terá um projeto com spring security oauth + social login.

* ver doc oficial do spring com oauth para obter mais detlhes.

* ao final, criar uma imagem para cada ms e comunicá-las pelo docker compose, utilizando as portas da própria aplicação.

Contexto:

cadastrar/obter músicas

---

### References

https://spring.io/guides/tutorials/spring-boot-oauth2/#github-register-application

https://docs.spring.io/spring-security/reference/5.6.0-RC1/servlet/oauth2/oauth2-login.html

https://www.youtube.com/watch?v=EQ5EwIYsgIE&t=786s

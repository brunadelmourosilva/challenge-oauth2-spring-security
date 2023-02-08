# challenge-oauth2-spring-security

Ideias:

-> OK microservice 1: criar um server authorization com spring

-> OK microservice 2: criar um microservice -> permite requisições com token
 -> conecta-se com meu authorization server criado(ms 1) e com o login social externo.

-> OK microservice 3: criar um app client que envia requisições para o microservice 2.
  
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

https://www.baeldung.com/spring-security-oauth-auth-server

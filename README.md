# 🚚 Rest API de logística 📦 do Mergulho Spring Rest da AlgaWorks 🤿

## 👨‍💻 Tecnologias utilizadas 👩‍💻

- Linguagem: Java
- Framework: Spring Framework - Spring Boot
- Banco de Dados: PostgreSQL

### 🗃️ Bibliotecas utilizadas 📚

- spring-boot-starter-web: Construção aplicações web com Spring MVC e container Tomcat embarcado
- spring-boot-devtools: Melhora na experiência de desenvolvimento com Spring (ex: LiveReload)
- spring-boot-starter-data-jpa: Implementação Java Persistence API do Spring, inclui Hibernate
- spring-boot-starter-validation: Bean de validação com Hibernate Validator
- lombok: anotações Java para reduzir boilerplate
- postgresql: driver para conexão com o banco de dados PostgreSQL
- flyway-core: migrate SQL - controle de versão de banco de dados
- modelmapper: Object Mapping para conversão de modelos em outros

## 😎 Boas Práticas 💼

- OffsetDateTime: representação imutável de uma data e hora com um deslocamento UTC
- Entity Model e DTO Model: separa as responsabilidades das classes de persistência e de transferência de dados incluindo validações, 
melhora o uso de banda de rede, caso não seja necessário o uso de todos os campos da entidade de persistência.
- ControllerAdvice: tratamento de exceções lançadas pela API em um único local, tirando essa responsabilidade
das classes de controller.
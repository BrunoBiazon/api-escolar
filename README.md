# API Escolar

## Sobre o projeto ( em andamento) 

#### Desenvolvendo uma API escolar em Spring Boot e MySQL com Flyway para as migrations, com o intuito de praticar os conhecimentos em Spring Boot e com foco em melhorar meu conhecimento em arquitetura de software.

-> Inicialmente, comecei o projeto com uma arquitetura dividida por módulos (Turma, Professor, Endereço, Pessoa, Aluno), porém decidi me desafiar trocando para a arquitetura de Monolito Modular, organizando o projeto através de divisão por módulos com subdivisão interna de camadas por domínio (controller, domain e dto). Futuramente pretendo criar uma subpastas para as classes services da aplicação, porém ainda estou estudando sobre como fazer;


```text
  -> Nome Modúlo
      -> domain 
          -> JPA e Repository
      -> controller
      -> dto
      -> service ( estudando sobre )
````

### Diagrama atual de como está no Banco de Dados.
<img width="962" height="824" alt="image" src="https://github.com/user-attachments/assets/e0a0000e-1483-4e24-8c1c-afbe4f3e87d6" />

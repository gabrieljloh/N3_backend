# *API RESTful para Gestão de Indústria, Automação e Processos*

*Alunos:* Gabriel Jorge Lóh e Gabriel Custódio Boelter  
*Professor:* Ramon Venson

---

## *Sumário*

1. [Visão Geral](#visão-geral)
2. [Tecnologias Utilizadas](#tecnologias-utilizadas)
3. [Funcionalidades](#funcionalidades)
4. [Estrutura do Projeto](#estrutura-do-projeto)
5. [Endpoints da API](#endpoints-da-api)
6. [Exemplos de Requisição e Resposta](#exemplos-de-requisição-e-resposta)
7. [Como Rodar o Projeto](#como-rodar-o-projeto)
8. [Considerações Finais](#considerações-finais)

---

## *Visão Geral*

Este projeto consiste em uma *API RESTful* desenvolvida para gerenciar um sistema de *indústria, automação e processos*. A API possui operações CRUD para três principais recursos:

- *Funcionários*
- *Máquinas*
- *Ordens de Serviço*

O sistema foi desenvolvido como parte da avaliação N3 da faculdade, com o objetivo de aplicar os conceitos de *arquitetura em camadas, **boas práticas de desenvolvimento* e *uso de DTOs* para a transferência de dados.

A API foi construída utilizando o framework *Spring Boot*, com validação de dados, tratamento de erros e mapeamento entre entidades e DTOs. Além disso, foi configurada para utilizar um banco de dados para persistência dos dados.

---

## *Tecnologias Utilizadas*

- *Spring Boot* – Framework para desenvolvimento de APIs RESTful
- *Spring Data JPA* – Para interação com o banco de dados
- *Hibernate* – Para mapeamento objeto-relacional (ORM)
- *Jackson* – Para conversão de objetos Java para JSON e vice-versa
- *Validation API* – Para validar dados de entrada
- *JUnit* – Para testes unitários
- *Maven* – Gerenciamento de dependências e build do projeto
- *Postman* – Para testes da API

---

## *Funcionalidades*

A API implementa operações básicas de CRUD para os seguintes recursos:

1. *Funcionários*: Cadastro, leitura, atualização e exclusão de funcionários.
2. *Máquinas*: Cadastro, leitura, atualização e exclusão de máquinas.
3. *Ordens de Serviço*: Cadastro, leitura, atualização e exclusão de ordens de serviço.

Além disso, a API conta com:

- Validação de dados de entrada (usando a *Bean Validation API*)
- Tratamento de erros global (com exceções personalizadas)
- Respostas claras e padronizadas para sucesso e falhas
- Organização do código em *camadas*: Controllers, Services, Repositories, DTOs e Mappers

---

## *Estrutura do Projeto*

O projeto está estruturado da seguinte forma:

src/ ├── main/ │ ├── java/ │ │ ├── com/ │ │ │ ├── example/ │ │ │ │ ├── backendFinal/ │ │ │ │ │ ├── controllers/ # Controllers para os recursos │ │ │ │ │ ├── dtos/ # DTOs para as respostas e requisições │ │ │ │ │ ├── exceptions/ # Tratamento de exceções │ │ │ │ │ ├── mappers/ # Mapeamento entre modelos e DTOs │ │ │ │ │ ├── models/ # Modelos das entidades │ │ │ │ │ ├── repositories/ # Repositórios para persistência │ │ │ │ │ └── services/ # Serviços para lógica de negócios │ ├── resources/ │ │ ├── application.properties # Configurações da aplicação ├── test/ │ └── java/ # Testes unitários do projeto

markdown
Copiar código

- *Controllers*: Responsáveis pelos endpoints da API.
- *DTOs*: Objetos de transferência de dados que são usados para comunicação entre o cliente e o servidor.
- *Exceptions*: Classe para tratar exceções globais e retornar respostas de erro adequadas.
- *Mappers*: Responsáveis por converter entre modelos e DTOs.
- *Models*: Representações das entidades que são persistidas no banco de dados.
- *Repositories*: Interfaces para comunicação com o banco de dados.
- *Services*: Contêm a lógica de negócios e interagem com os repositórios.

---

## *Endpoints da API*

### *Funcionários*

- POST /funcionarios – Cria um novo funcionário
- GET /funcionarios – Lista todos os funcionários
- GET /funcionarios/{id} – Recupera um funcionário por ID
- DELETE /funcionarios/{id} – Deleta um funcionário por ID

### *Máquinas*

- POST /maquinas – Cria uma nova máquina
- GET /maquinas – Lista todas as máquinas
- GET /maquinas/{id} – Recupera uma máquina por ID
- DELETE /maquinas/{id} – Deleta uma máquina por ID

### *Ordens de Serviço*

- POST /ordens – Cria uma nova ordem de serviço
- GET /ordens – Lista todas as ordens de serviço
- GET /ordens/{id} – Recupera uma ordem de serviço por ID
- DELETE /ordens/{id} – Deleta uma ordem de serviço por ID

---

## *Exemplos de Requisição e Resposta*

### *1. Criar Funcionário*

*Requisição*:

```json
POST /funcionarios
{
  "nome": "Gabriel Lóh",
  "cargo": "Operador",
  "turno": "Manhã"
}
Resposta:

json
Copiar código
{
  "id": "123e4567-e89b-12d3-a456-426614174000",
  "nome": "Gabriel Lóh",
  "cargo": "Operador",
  "turno": "Manhã",
  "status": "Ativo"
}
2. Buscar Máquina por ID
Requisição:

json
Copiar código
GET /maquinas/{id}
Resposta:

json
Copiar código
{
  "id": "123e4567-e89b-12d3-a456-426614174001",
  "nome": "Máquina X",
  "modelo": "Model 1",
  "fabricante": "Fabricante Y",
  "status": "Ativa"
}
Como Rodar o Projeto
Para rodar o projeto localmente, siga os seguintes passos:

Pré-requisitos:
Java 17 ou superior
Maven
IDE (como IntelliJ IDEA, Eclipse ou VSCode)
Passos:
Clone o repositório:

bash
Copiar código
git clone https://github.com/seu-usuario/backend-final.git
Navegue até o diretório do projeto:

bash
Copiar código
cd backend-final
Compile o projeto usando o Maven:

bash
Copiar código
mvn clean install
Execute o projeto:

bash
Copiar código
mvn spring-boot:run
Acesse a API em http://localhost:8080.

Considerações Finais
Este projeto foi desenvolvido com foco na qualidade de código, padronização e boas práticas de desenvolvimento de APIs RESTful. Com a implementação de DTOs, validação de dados e tratamento adequado de exceções, o projeto garante uma experiência robusta para quem for utilizar a API.

Agradecemos ao professor Ramon Venson pela orientação e apoio ao longo do desenvolvimento deste projeto, e também à nossa equipe de desenvolvimento, composta pelos alunos Gabriel Jorge Lóh e Gabriel Custódio Boelter.
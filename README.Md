# *API RESTFUL para Gestão de Indústria, Automação e Processos*

*Alunos:* Gabriel Jorge Lóh e Gabriel Custódio Boelter  
*Professor:* Ramon Venson

---

## *Visão Geral*

Este projeto consiste em uma *API RESTFUL* desenvolvida para gerenciar um sistema de *indústria, automação e processos*. A API possui operações CRUD para três principais recursos:

- *Funcionários*
- *Máquinas*
- *Ordens de Serviço*

---

## *Tecnologias Utilizadas*

- *Spring Boot* – Framework para desenvolvimento de APIs RESTful
- *Spring Data JPA* – Para interação com o banco de dados
- *Hibernate* – Para mapeamento objeto-relacional (ORM)
- *Validation API* – Para validar dados de entrada
- *Maven* – Gerenciamento de dependências e build do projeto
- *Postman* – Para testes da API
- *H2* - Para banco de dados.

---

## *Funcionalidades*

Operações básicas de CRUD para os seguintes recursos:

1. *Funcionários*: Cadastro, leitura, atualização e exclusão de funcionários.
2. *Máquinas*: Cadastro, leitura, atualização e exclusão de máquinas.
3. *Ordens de Serviço*: Cadastro, leitura, atualização e exclusão de ordens de serviço.

Além disso, o projeto conta com:

- Validação de dados de entrada
- Tratamento de erros global (com exceções personalizadas)
- Respostas claras e padronizadas para sucesso e falhas
- Organização do código em *camadas*: Controllers, Services, Repositories, DTOs e Mappers

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
{
  "id": "123e4567-e89b-12d3-a456-426614174000",
  "nome": "Gabriel Lóh",
  "cargo": "Operador",
  "turno": "Manhã",
  "status": "Ativo"
}
2. Buscar Máquina por ID

Requisição:

GET /maquinas/{id}
Resposta:

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

git clone https://github.com/seu-usuario/backend-final.git

Navegue até o diretório do projeto:

cd backend-final
Compile o projeto usando o Maven:

mvn clean install
Execute o projeto:

mvn spring-boot:run
Acesse a API em http://localhost:8080.


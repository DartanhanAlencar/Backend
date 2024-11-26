# Pasta Controller - Projeto AlunoOnline API

Este diretório faz parte da API AlunoOnline, que utiliza o Spring Boot para gerenciar operações relacionadas à administração de alunos, professores, disciplinas e matrículas. A API foi desenvolvida seguindo os princípios de MVC (Model-View-Controller), sendo a camada Controller responsável por lidar com as requisições HTTP e direcioná-las para os serviços apropriados.

## Dependências Utilizadas no Controller

As classes da pasta `controller` utilizam diversas importações do Spring para configurar os endpoints da API. Abaixo estão as principais dependências:

- `@RestController`: Define que a classe é um controlador REST, gerando respostas no formato JSON ou XML.
- `@RequestMapping`: Especifica o caminho base para os endpoints dessa classe.
- `@PostMapping` / `@PatchMapping` / `@GetMapping`: Anotam os métodos que lidam com requisições HTTP (POST, PATCH e GET).
- `@PathVariable`: Captura parâmetros da URL para serem utilizados no método.
- `@RequestBody`: Converte o corpo da requisição em um objeto Java, usado para receber dados JSON ou XML enviados pelo cliente.
- `@ResponseStatus`: Define o status HTTP que será retornado após a execução do método.

## Controladores e Suas Funções

### 1. **AlunoController**

**Responsabilidade**:  
Gerencia operações sobre alunos, como criar, buscar, atualizar e deletar.

**Bibliotecas Utilizadas**:  
- `@RestController` para definir endpoints REST.
- `@Autowired` para injeção de dependência da camada de serviço.
- `@RequestBody` e `@PathVariable` para processar dados das requisições.

### 2. **DisciplinaController**

**Responsabilidade**:  
Gerencia disciplinas, permitindo criar e buscar disciplinas por professor.

**Bibliotecas Utilizadas**:  
- `@RestController` para criar endpoints relacionados a disciplinas.
- `@GetMapping` e `@PostMapping` para manipulação de dados.

### 3. **MatriculaAlunoController**

**Responsabilidade**:  
Gerencia matrículas, incluindo criação, atualização de notas e status, e geração de históricos acadêmicos.

**Bibliotecas Utilizadas**:  
- `@PatchMapping` para operações parciais (atualização de notas e status).
- `@ResponseStatus` para controlar os status HTTP retornados.

### 4. **ProfessorController**

**Responsabilidade**:  
Gerencia professores, atualmente com suporte à criação de registros.

**Bibliotecas Utilizadas**:  
- `@RequestBody` para receber os dados do professor no corpo da requisição.
- `@PostMapping` para criar um novo professor.

## Resumo da Estrutura

O projeto segue uma arquitetura modular organizada, com responsabilidades claramente definidas para cada camada. A camada **controller** se comunica diretamente com a camada **service**, garantindo que as regras de negócio e a lógica de persistência sejam mantidas fora dos controladores. Essa separação facilita a escalabilidade, manutenção e testes do sistema.
Este projeto está licenciado sob a MIT License - consulte o arquivo LICENSE para mais detalhes.

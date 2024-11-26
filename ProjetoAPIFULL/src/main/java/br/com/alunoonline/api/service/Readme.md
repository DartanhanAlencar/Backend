# Service Layer

A pasta **service** contém os serviços responsáveis pela lógica de negócios do sistema. Cada serviço lida com a manipulação e processamento de dados, interagindo com os repositórios para acessar e modificar informações no banco de dados. Abaixo estão os arquivos contidos nesta pasta, bem como suas funções.

## Bibliotecas Utilizadas

- **Spring Framework**:
  - **Spring Web**: Usado para criar APIs RESTful e manipular as requisições HTTP.
  - **Spring Data JPA**: Para interação com o banco de dados via repositórios JPA, permitindo salvar, buscar, atualizar e deletar entidades de forma simples.
  - **Spring Scheduling**: Usado para a execução de tarefas programadas (crons), como a geração de faturas no sistema.
  - **Spring Boot**: Facilita a configuração e inicialização do aplicativo com uma configuração mínima.

- **SLF4J (Simple Logging Facade for Java)**:
  - Usado para logar mensagens de depuração, erro, e informação sobre o andamento do sistema.

## Arquivos

### `AlunoService.java`
Responsável pela manipulação dos dados de **Aluno** no sistema. As principais funções deste serviço são:
- **create()**: Cria um novo aluno, associando-o a um curso.
- **findAll()**: Retorna todos os alunos cadastrados no sistema.
- **findById()**: Retorna um aluno específico dado seu ID.
- **update()**: Atualiza os dados de um aluno.
- **deleteById()**: Remove um aluno do sistema.
- **createFinanceiroInformation()**: Cria informações financeiras associadas a um aluno recém-cadastrado.

### `DisciplinaService.java`
Gerencia as operações relacionadas às **Disciplinas**. As principais funções são:
- **create()**: Cria uma nova disciplina no sistema.
- **findByProfessorId()**: Retorna uma lista de disciplinas atribuídas a um professor específico.

### `FinanceiroService.java`
Responsável pela manipulação das **faturas** e **informações financeiras** dos alunos. As principais funções incluem:
- **faturaGeneration()**: Gera faturas para os alunos com base nas datas de vencimento e prazos predefinidos.
- **calculateDueDate()**: Calcula a data de vencimento da fatura de acordo com o mês e o dia definidos.

### `MatriculaAlunoService.java`
Lida com a matrícula dos alunos nas disciplinas. As funções principais incluem:
- **create()**: Cria uma nova matrícula de aluno em uma disciplina.
- **updateGrades()**: Atualiza as notas de um aluno em uma disciplina.
- **updateStudentGrades()**: Atualiza individualmente as notas de um aluno.
- **updateStudentStatus()**: Atualiza o status da matrícula (aprovado, reprovado) com base nas notas.
- **updateStatusToBreak()**: Permite trancar a matrícula de um aluno.
- **changeStatus()**: Altera o status da matrícula do aluno.
- **getAcademicTranscript()**: Retorna o histórico acadêmico de um aluno, com suas disciplinas, notas e status.

### `ProfessorService.java`
Gerencia as operações relacionadas aos **Professores**. As funções principais são:
- **create()**: Cria um novo professor no sistema.


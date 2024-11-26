# Repositórios da API

Este diretório contém os repositórios da aplicação, responsáveis pela interação com o banco de dados utilizando o Spring Data JPA. Cada repositório herda de `JpaRepository` e fornece métodos para realizar operações CRUD em suas respectivas entidades.

## Bibliotecas Utilizadas

- **Spring Data JPA**: Biblioteca que facilita a interação com o banco de dados utilizando JPA (Java Persistence API). Ela permite que você crie repositórios com métodos prontos para realizar operações no banco de dados, sem a necessidade de escrever SQL ou JPQL manualmente.

    - **Dependência no `pom.xml`**:
      ```xml
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-data-jpa</artifactId>
      </dependency>
      ```

- **Spring Boot**: Framework que facilita a criação de aplicações Java com configuração mínima e otimizações automáticas, incluindo o suporte a repositórios e integração com o banco de dados.

## Função de Cada Arquivo

### 1. `AlunoRepository.java`

Responsável pela interação com a entidade `Aluno`. Estende `JpaRepository<Aluno, Long>` e herda métodos CRUD para gerenciar a entidade `Aluno`. Este repositório pode ser utilizado para salvar, atualizar, excluir e consultar alunos no banco de dados.

**Funções principais:**
- Salvar e atualizar alunos.
- Buscar alunos pelo ID.
- Buscar todos os alunos.

### 2. `CursoRepository.java`

Responsável pela interação com a entidade `Curso`. Estende `JpaRepository<Curso, Long>`, permitindo a execução das operações CRUD para a entidade `Curso`. Esse repositório pode ser utilizado para gerenciar cursos no banco de dados.

**Funções principais:**
- Salvar e atualizar cursos.
- Buscar cursos pelo ID.
- Buscar todos os cursos.

### 3. `DisciplinaRepository.java`

Responsável pela interação com a entidade `Disciplina`. Estende `JpaRepository<Disciplina, Long>` e inclui um método personalizado `findByProfessorId`, que permite buscar disciplinas associadas a um determinado professor.

**Funções principais:**
- Salvar e atualizar disciplinas.
- Buscar disciplinas pelo ID.
- Buscar disciplinas de um professor específico.

### 4. `FaturaRepository.java`

Responsável pela interação com a entidade `Fatura`. Estende `JpaRepository<Fatura, Long>` e inclui um método personalizado `existsByStudentFinancialAndDueDate`, que verifica se uma fatura com uma determinada data de vencimento já existe para um aluno.

**Funções principais:**
- Salvar e atualizar faturas.
- Verificar a existência de faturas com um determinado `studentFinancial` e `dueDate`.

### 5. `FinanceiroAlunoRepository.java`

Responsável pela interação com a entidade `FinanceiroAluno`. Estende `JpaRepository<FinanceiroAluno, Long>` e fornece os métodos CRUD para gerenciar as finanças dos alunos.

**Funções principais:**
- Salvar e atualizar informações financeiras de alunos.
- Buscar informações financeiras de alunos pelo ID.

### 6. `MatriculaAlunoRepository.java`

Responsável pela interação com a entidade `MatriculaAluno`. Estende `JpaRepository<MatriculaAluno, Long>` e inclui um método personalizado `findByStudentId`, que permite buscar todas as matrículas de um aluno com base no seu `studentId`.

**Funções principais:**
- Salvar e atualizar matrículas.
- Buscar matrículas de um aluno específico.

### 7. `ProfessorRepository.java`

Responsável pela interação com a entidade `Professor`. Estende `JpaRepository<Professor, Long>` e fornece os métodos CRUD para gerenciar os professores no banco de dados.

**Funções principais:**
- Salvar e atualizar professores.
- Buscar professores pelo ID.
- Buscar todos os professores.


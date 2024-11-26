# Pasta `model` - Sistema de Gestão de Alunos Online

Este diretório contém as classes de modelo (model) utilizadas no sistema de gestão de alunos online. As classes representadas aqui são responsáveis pela definição das entidades que serão mapeadas para o banco de dados usando JPA (Java Persistence API). Cada classe corresponde a uma tabela no banco de dados e define os atributos e relacionamentos entre as entidades.

## Funcionalidades das Classes

### 1. **Aluno**
- **Função**: Representa um aluno no sistema. A classe contém informações como nome, e-mail e o curso no qual o aluno está matriculado.
- **Relacionamentos**:
  - `ManyToOne` com a classe `Curso`, indicando que cada aluno está matriculado em um único curso.

### 2. **Curso**
- **Função**: Representa um curso oferecido no sistema. A classe contém informações como nome do curso, tipo e custo mensal.
- **Relacionamentos**:
  - A classe possui um campo `type`, que usa a enumeração `CursoTypeEnum` para representar o tipo do curso (ex: presencial, online).
  
### 3. **Disciplina**
- **Função**: Representa uma disciplina no sistema, associada a um professor. Contém o nome da disciplina e um relacionamento com a classe `Professor`.
- **Relacionamentos**:
  - `ManyToOne` com a classe `Professor`, indicando que uma disciplina tem um único professor.

### 4. **Fatura**
- **Função**: Representa a fatura de um aluno no sistema, com informações sobre o valor a ser pago, data de vencimento e data de pagamento.
- **Relacionamentos**:
  - `ManyToOne` com a classe `FinanceiroAluno`, indicando que cada fatura está associada a um aluno.

### 5. **FinanceiroAluno**
- **Função**: Representa o estado financeiro de um aluno, com informações sobre descontos, data de vencimento e status financeiro.
- **Relacionamentos**:
  - `OneToOne` com a classe `Aluno`, indicando que cada aluno tem um único registro financeiro.

### 6. **MatriculaAluno**
- **Função**: Representa a matrícula de um aluno em uma disciplina. Contém as notas de duas avaliações e o status da matrícula.
- **Relacionamentos**:
  - `ManyToOne` com a classe `Aluno` e `Disciplina`, indicando que um aluno pode estar matriculado em várias disciplinas.

### 7. **Professor**
- **Função**: Representa um professor no sistema. A classe contém informações como nome e e-mail do professor.

## Bibliotecas Utilizadas

As classes do modelo utilizam as seguintes bibliotecas para o mapeamento objeto-relacional (ORM) e outras funcionalidades:

### 1. **Jakarta Persistence (JPA)**:
- **Biblioteca**: `jakarta.persistence`
- **Função**: Usada para o mapeamento objeto-relacional (ORM), permitindo que as classes Java sejam mapeadas para tabelas no banco de dados. As anotações JPA, como `@Entity`, `@Id`, `@ManyToOne`, `@OneToOne`, e `@Enumerated`, são usadas para definir os relacionamentos e comportamento das entidades.

### 2. **Lombok**:
- **Biblioteca**: `lombok`
- **Função**: Usada para reduzir o código boilerplate. As anotações `@AllArgsConstructor`, `@NoArgsConstructor` e `@Data` geram automaticamente construtores, métodos `getters`, `setters`, `toString()`, `equals()` e `hashCode()` para as classes.

### 3. **Java Time API**:
- **Biblioteca**: `java.time`
- **Função**: Usada para lidar com tipos de dados de data e hora, como `LocalDateTime` e `LocalDate`, no caso da classe `Fatura` (para armazenar datas como vencimento, pagamento e criação).

### 4. **Enumeração (Java Enum)**:
- **Biblioteca**: `br.com.alunoonline.api.enums`
- **Função**: As enumerações como `CursoTypeEnum`, `FinanceiroStatusEnum` e `MatriculaAlunoStatusEnum` são usadas para representar valores fixos e pré-definidos, proporcionando maior clareza e controle sobre os dados.


